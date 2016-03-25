package demo.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReplyConfig {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	MessageConverter json2MessageConverter;
	
	final static String queueName = "reply-queue";
	
	/**
	 
	 * Queue(String name, boolean durable, boolean exclusive, boolean
	 * autoDelete, Map<String,Object> arguments) Construct a new queue, given a
	 * name, durability flag, and auto-delete flag, and arguments.
	 * excluseive 表示 if the server should only send messages to the declarer's
	 */

	@Bean
	Queue reply_queue() {
		return new Queue(queueName, true, false, true, null);
	}
	
	/**
	 * TopicExchange(String name) TopicExchange(String name, boolean durable,
	 * boolean autoDelete) TopicExchange(String name, boolean durable, boolean
	 * autoDelete, Map<String,Object> arguments)
	 */
	@Bean
	TopicExchange reply_exchange() {
		return new TopicExchange("reply-exchange", true, true);
	}
	
	@Bean
	Binding reply_binding() {
		return BindingBuilder.bind(reply_queue()).to(reply_exchange()).with(queueName);
	}

	@Bean
	// configure a routing connection factory ,this is a long-lived container
	SimpleMessageListenerContainer container(CachingConnectionFactory rabbitConnectionFactory) {
		// 设置的channelCacheSize 不能小于 application.yml中的concurrency: 3
		rabbitConnectionFactory.setChannelCacheSize(15);
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(rabbitConnectionFactory);

		// the lookup key is queueName
		container.setQueueNames(queueName);
		// 接受消息时候，json格式
		container.setMessageConverter(json2MessageConverter);
		// 如果接听者接听失败，消息将回滚
		// 使用confirm，不使用transaction
		// container.setChannelTransacted(true);
		// it can cause messages already consumed not to be acknowledged until
		// the timeout expires.
		container.setReceiveTimeout(3000);
		container.setMessageListener(rabbitTemplate);
		//container.setMessageListener(rabbitTemplate);
		return container;
	}
	
}

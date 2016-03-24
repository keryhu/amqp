package demo.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * this is demonstrate spring-amqp rabbit confirm function.
 * @author hushuming
 *
 */
@Component
public class RabbitConfig {
	
	

	
	final static String queueName = "confirm-queue";
	
	/**
	 
	 * Queue(String name, boolean durable, boolean exclusive, boolean
	 * autoDelete, Map<String,Object> arguments) Construct a new queue, given a
	 * name, durability flag, and auto-delete flag, and arguments.
	 * excluseive 表示 if the server should only send messages to the declarer's
	 */

	@Bean
	Queue queue() {
		return new Queue(queueName, true, false, true, null);
	}
	
	/**
	 * TopicExchange(String name) TopicExchange(String name, boolean durable,
	 * boolean autoDelete) TopicExchange(String name, boolean durable, boolean
	 * autoDelete, Map<String,Object> arguments)
	 */
	@Bean
	TopicExchange exchange() {
		return new TopicExchange("confirm-exchange", true, true);
	}
	
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}
	
	@Bean
	// configure a routing connection factory ,this is a long-lived container
	SimpleMessageListenerContainer container(CachingConnectionFactory rabbitConnectionFactory) {
		// 设置的channelCacheSize 不能小于 application.yml中的concurrency: 3
		rabbitConnectionFactory.setChannelCacheSize(15);
		// 设置confirm和reply必须要设置下面的为true
		rabbitConnectionFactory.setPublisherConfirms(true);
		rabbitConnectionFactory.setPublisherReturns(true);
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(rabbitConnectionFactory);

		// the lookup key is queueName
		container.setQueueNames(queueName);
		// 接受消息时候，json格式
		//container.setMessageConverter(json2MessageConverter());
		// 如果接听者接听失败，消息将回滚
		// 使用confirm，不使用transaction
		// container.setChannelTransacted(true);
		// it can cause messages already consumed not to be acknowledged until
		// the timeout expires.
		container.setReceiveTimeout(3000);
		container.setMessageListener(new MessageListenerAdapter(new Receiver()));
		//container.setMessageListener(rabbitTemplate);
		return container;
	}
	
	@Bean
	public MessageConverter json2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	/**
	 * Create a new MessageListenerAdapter for the given delegate. 调用的是receive中
	 * receiveMessage 方法。 其中receiver 是自己创建的，
	 */
	
	
	


}

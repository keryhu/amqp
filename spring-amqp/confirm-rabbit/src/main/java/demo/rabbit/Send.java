package demo.rabbit;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.core.Queue;

/**
 * 自己创建一个url，实现send rabbitmq message的方法调用，
 * 
 * @author hushuming
 *
 */
@RestController
public class Send {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	
	

	@RequestMapping("/s")
	public String send_topic() {
		// 发布消息的时候，如果实行json2格式，会达不到预期。如果发送的是message对象，则重新试下。
		// 调用send 方法。第一个参数是route－key，第二个参数是发送的message具体的内容

		final AtomicReference<CorrelationData> confirmCD = new AtomicReference<CorrelationData>();
		final CountDownLatch latch = new CountDownLatch(1);
		
		rabbitTemplate.setConfirmCallback(new ConfirmCallback() {
			@Override
			public void confirm(CorrelationData correlationData, boolean ack, String cause) {
				// TODO Auto-generated method stub
				confirmCD.set(correlationData);
				
				// 如果发送message失败，那么就重试。
				if (!ack) {
					//retrySend.send("spring-boots5", message, new CorrelationData(UUID.randomUUID().toString()));
					// 以后加上log日志，报错，Log.ERROR()
					StringBuffer sb=new StringBuffer("confirm correlationData is : ");
					sb.append(correlationData).append("  , ack is : ").append(ack);
					System.out.println(sb);
				}

			}

		});
		// 设置发送confirm和回复的必须要设置下面这个为true
		
		CorrelationData correlationData = new CorrelationData("abc");

		rabbitTemplate.setMandatory(true);
		rabbitTemplate.setReplyAddress("reply-queue");
		
		// 设置rabbitTemplate的retry 功能

		String result = (String)rabbitTemplate.convertSendAndReceive("confirm-queue", (Object)"hello",correlationData);

		
		System.out.println("confirmCD.get() is : "+confirmCD.get());
		System.out.println("result is : "+result);
		// 返回的对象，证明spring controller url正确
		return "this is confirm-rabbit send page ! ";
	}

}

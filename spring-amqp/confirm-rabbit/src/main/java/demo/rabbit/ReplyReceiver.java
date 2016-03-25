package demo.rabbit;


import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;


/**
 * spring rabbitmq receiver 的接收器
 * @author hushuming
 */

@Component
public class ReplyReceiver {
	
     @RabbitListener(queues = "reply-queue")
    // @RabbitHandler
    // @SendTo("confirm-exchange/confirm-queue")
	public String handleMessage(String s){
		System.out.println("this is the receive message --< "+s+" >");
		//接受消息是，打印的是这行内容，其中message 是由 rabbitTemplate的send 的第二个参数来 填充。
		//如果message内容不为空，那么就调用另外一个方法，print(),这个非常有用，接受到什么消息，做出什么决定，
		//例如用户注册成功后，促发邮件验证功能。
			
		return s.toUpperCase();
	}
	
	
   
    
}

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
	public void handleMessage(String s){
		System.out.println("this is the reply :  --< "+s+" >");
			
	}
}

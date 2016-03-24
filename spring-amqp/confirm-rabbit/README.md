# confirm-rabbit

when run the application

open the  http://localhost:8080/s (to send message )

the console error is :


	2016-03-24 21:20:13.333[0;39m [32m INFO[0;39m [35m45278[0;39m [2m---[0;39m [2m[cTaskExecutor-1][0;39m [36mo.s.amqp.rabbit.core.RabbitAdmin        [0;39m [2m:[0;39m Auto-declaring a non-durable, auto-delete, or exclusive Queue (confirm-queue) durable:true, auto-delete:true, exclusive:false. It will be redeclared if the broker stops and is restarted while the connection factory is alive, but all messages will be lost.
	[2m2016-03-24 21:20:13.525[0;39m [32m INFO[0;39m [35m45278[0;39m [2m---[0;39m [2m[           main][0;39m [36ms.b.c.e.t.TomcatEmbeddedServletContainer[0;39m [2m:[0;39m Tomcat started on port(s): 8080 (http)
	[2m2016-03-24 21:20:13.531[0;39m [32m INFO[0;39m [35m45278[0;39m [2m---[0;39m [2m[           main][0;39m [36mdemo.Application                        [0;39m [2m:[0;39m Started Application in 6.807 seconds (JVM running for 7.59)
	[2m2016-03-24 21:20:24.311[0;39m [32m INFO[0;39m [35m45278[0;39m [2m---[0;39m [2m[nio-8080-exec-1][0;39m [36mo.a.c.c.C.[Tomcat].[localhost].[/]      [0;39m [2m:[0;39m Initializing Spring FrameworkServlet 'dispatcherServlet'
	[2m2016-03-24 21:20:24.312[0;39m [32m INFO[0;39m [35m45278[0;39m [2m---[0;39m [2m[nio-8080-exec-1][0;39m [36mo.s.web.servlet.DispatcherServlet       [0;39m [2m:[0;39m FrameworkServlet 'dispatcherServlet': initialization started
	[2m2016-03-24 21:20:24.328[0;39m [32m INFO[0;39m [35m45278[0;39m [2m---[0;39m [2m[nio-8080-exec-1][0;39m [36mo.s.web.servlet.DispatcherServlet       [0;39m [2m:[0;39m FrameworkServlet 'dispatcherServlet': initialization completed in 16 ms
	this is the receive message --< hello >
	正在调用receive().print方法
	[2m2016-03-24 21:20:24.405[0;39m [31mERROR[0;39m [35m45278[0;39m [2m---[0;39m [2m[ 127.0.0.1:5672][0;39m [36mo.s.a.r.s.PublisherCallbackChannelImpl  [0;39m [2m:[0;39m No listener for seq:1
	confirmCD.get() is : CorrelationData [id=abc]
	result is : HELLO
	
	
	
	

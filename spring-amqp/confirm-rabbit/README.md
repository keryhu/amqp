# confirm-rabbit

## update: Mar 25 

I have added the reply queue and a listener (ReplyReceiver). 

The error 

	no listener for seq 

is disappeared, that's great !

But ...

	confirmCD.get() is : null

  appears again!
  
   Today 
i use the terminal to run this program (worrying about  STS affects it) , **i tryed twice ,the result is the same .**

	java -jar  target/confirm-rabbit-0.0.1-SNAPSHOT.jar 

and 

	open the  http://localhost:8080/s (to send message )

The whole export from terminal :


		keryhudeMacBook-Pro:confirm-rabbit hushuming$ java -jar t*/c*r
	
	  .   ____          _            __ _ _
	 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
	( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
	 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
	  '  |____| .__|_| |_|_| |_\__, | / / / /
	 =========|_|==============|___/=/_/_/_/
	 :: Spring Boot ::        (v1.3.3.RELEASE)
	
	2016-03-25 09:13:51.246  INFO 51103 --- [           main] demo.Application                         : Starting Application v0.0.1-SNAPSHOT on keryhudeMacBook-Pro.local with PID 51103 (/Users/hushuming/Desktop/git-repo/spring-amqp/spring-amqp/confirm-rabbit/target/confirm-rabbit-0.0.1-SNAPSHOT.jar started by hushuming in /Users/hushuming/Desktop/git-repo/spring-amqp/spring-amqp/confirm-rabbit)
	2016-03-25 09:13:51.255  INFO 51103 --- [           main] demo.Application                         : No active profile set, falling back to default profiles: default
	2016-03-25 09:13:51.372  INFO 51103 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@71587475: startup date [Fri Mar 25 09:13:51 CST 2016]; root of context hierarchy
	2016-03-25 09:13:52.445  INFO 51103 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'container' with a different definition: replacing [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=rabbitConfig; factoryMethodName=container; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [demo/rabbit/RabbitConfig.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=replyConfig; factoryMethodName=container; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [demo/rabbit/ReplyConfig.class]]
	2016-03-25 09:13:52.565  INFO 51103 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'beanNameViewResolver' with a different definition: replacing [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration; factoryMethodName=beanNameViewResolver; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter; factoryMethodName=beanNameViewResolver; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter.class]]
	2016-03-25 09:13:53.168  INFO 51103 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.amqp.rabbit.annotation.RabbitBootstrapConfiguration' of type [class org.springframework.amqp.rabbit.annotation.RabbitBootstrapConfiguration$$EnhancerBySpringCGLIB$$8f1cff74] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
	2016-03-25 09:13:53.938  INFO 51103 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
	2016-03-25 09:13:53.961  INFO 51103 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
	2016-03-25 09:13:53.963  INFO 51103 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.0.32
	2016-03-25 09:13:54.151  INFO 51103 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	2016-03-25 09:13:54.151  INFO 51103 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2782 ms
	2016-03-25 09:13:55.076  INFO 51103 --- [ost-startStop-1] o.s.b.c.e.ServletRegistrationBean        : Mapping servlet: 'dispatcherServlet' to [/]
	2016-03-25 09:13:55.090  INFO 51103 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'metricFilter' to: [/*]
	2016-03-25 09:13:55.091  INFO 51103 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'characterEncodingFilter' to: [/*]
	2016-03-25 09:13:55.091  INFO 51103 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
	2016-03-25 09:13:55.092  INFO 51103 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'httpPutFormContentFilter' to: [/*]
	2016-03-25 09:13:55.092  INFO 51103 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'requestContextFilter' to: [/*]
	2016-03-25 09:13:55.092  INFO 51103 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'webRequestLoggingFilter' to: [/*]
	2016-03-25 09:13:55.092  INFO 51103 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'applicationContextIdFilter' to: [/*]
	2016-03-25 09:13:55.907  INFO 51103 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@71587475: startup date [Fri Mar 25 09:13:51 CST 2016]; root of context hierarchy
	2016-03-25 09:13:56.030  INFO 51103 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/s]}" onto public java.lang.String demo.rabbit.Send.send_topic()
	2016-03-25 09:13:56.033  INFO 51103 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
	2016-03-25 09:13:56.034  INFO 51103 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
	2016-03-25 09:13:56.102  INFO 51103 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	2016-03-25 09:13:56.102  INFO 51103 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	2016-03-25 09:13:56.183  INFO 51103 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	2016-03-25 09:13:56.846  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/trace || /trace.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 09:13:56.847  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/beans || /beans.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 09:13:56.848  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/health || /health.json],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(java.security.Principal)
	2016-03-25 09:13:56.849  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)
	2016-03-25 09:13:56.850  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env || /env.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 09:13:56.850  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/mappings || /mappings.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 09:13:56.853  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/dump || /dump.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 09:13:56.855  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/info || /info.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 09:13:56.856  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 09:13:56.857  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/configprops || /configprops.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 09:13:56.858  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)
	2016-03-25 09:13:56.858  INFO 51103 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics || /metrics.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 09:13:57.076  INFO 51103 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
	2016-03-25 09:13:57.089  INFO 51103 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase -2147482648
	2016-03-25 09:13:57.090  INFO 51103 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 0
	2016-03-25 09:13:57.180  INFO 51103 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
	2016-03-25 09:13:57.317  INFO 51103 --- [cTaskExecutor-1] o.s.a.r.c.CachingConnectionFactory       : Created new connection: SimpleConnection@3f1c4eac [delegate=amqp://wfij@127.0.0.1:5672//wfij]
	2016-03-25 09:13:57.318  INFO 51103 --- [cTaskExecutor-1] o.s.amqp.rabbit.core.RabbitAdmin         : Auto-declaring a non-durable or auto-delete Exchange (confirm-exchange) durable:true, auto-delete:true. It will be deleted by the broker if it shuts down, and can be redeclared by closing and reopening the connection.
	2016-03-25 09:13:57.319  INFO 51103 --- [cTaskExecutor-1] o.s.amqp.rabbit.core.RabbitAdmin         : Auto-declaring a non-durable or auto-delete Exchange (reply-exchange) durable:true, auto-delete:true. It will be deleted by the broker if it shuts down, and can be redeclared by closing and reopening the connection.
	2016-03-25 09:13:57.319  INFO 51103 --- [cTaskExecutor-1] o.s.amqp.rabbit.core.RabbitAdmin         : Auto-declaring a non-durable, auto-delete, or exclusive Queue (confirm-queue) durable:true, auto-delete:true, exclusive:false. It will be redeclared if the broker stops and is restarted while the connection factory is alive, but all messages will be lost.
	2016-03-25 09:13:57.319  INFO 51103 --- [cTaskExecutor-1] o.s.amqp.rabbit.core.RabbitAdmin         : Auto-declaring a non-durable, auto-delete, or exclusive Queue (reply-queue) durable:true, auto-delete:true, exclusive:false. It will be redeclared if the broker stops and is restarted while the connection factory is alive, but all messages will be lost.
	2016-03-25 09:13:57.544  INFO 51103 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
	2016-03-25 09:13:57.550  INFO 51103 --- [           main] demo.Application                         : Started Application in 7.006 seconds (JVM running for 7.626)
	2016-03-25 09:14:00.953  INFO 51103 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
	2016-03-25 09:14:00.954  INFO 51103 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
	2016-03-25 09:14:00.978  INFO 51103 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 24 ms
	this is the receive message --< hello >
	正在调用receive().print方法
	confirmCD.get() is : null
	result is : HELLO

Maybe there is some mistake in my program , but not  knowing how resolve it .
	
	
	
	

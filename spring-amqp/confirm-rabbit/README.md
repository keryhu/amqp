# confirm-rabbit

## update: Mar 25  Again

have added the 1.5.5 in the pom.xml:

		<parent>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-parent</artifactId>
				<version>1.3.3.RELEASE</version>
				<relativePath /> <!-- lookup parent from repository -->
			</parent>
		
			<properties>
				<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
				<java.version>1.8</java.version>
				<lombok.version>1.16.6</lombok.version>
			</properties>
		
		
			<dependencies>
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-web</artifactId>
				</dependency>
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-actuator</artifactId>
				</dependency>
				<dependency>
					<groupId>org.springframework.amqp</groupId>
					<artifactId>spring-rabbit</artifactId>
					<version>1.5.5.RELEASE</version>
				</dependency>
				<dependency>
					<groupId>org.projectlombok</groupId>
					<artifactId>lombok</artifactId>
					<version>${lombok.version}</version>
				</dependency>
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-amqp</artifactId>
				</dependency>
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-aop</artifactId>
				</dependency>
				<dependency>
					<groupId>org.springframework.retry</groupId>
					<artifactId>spring-retry</artifactId>
				</dependency>
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-test</artifactId>
					<scope>test</scope>
				</dependency>
			</dependencies>


the terminal export: 

	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 5.817 s
	[INFO] Finished at: 2016-03-25T21:40:02+08:00
	[INFO] Final Memory: 32M/280M
	[INFO] ------------------------------------------------------------------------
	keryhudeMacBook-Pro:confirm-rabbit hushuming$ ls
	README.md	pom.xml		src		target
	keryhudeMacBook-Pro:confirm-rabbit hushuming$ ls t*/
	classes						generated-sources				test-classes
	confirm-rabbit-0.0.1-SNAPSHOT.jar		maven-archiver
	confirm-rabbit-0.0.1-SNAPSHOT.jar.original	maven-status
	keryhudeMacBook-Pro:confirm-rabbit hushuming$ java -jar t*/c*r
	
	  .   ____          _            __ _ _
	 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
	( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
	 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
	  '  |____| .__|_| |_|_| |_\__, | / / / /
	 =========|_|==============|___/=/_/_/_/
	 :: Spring Boot ::        (v1.3.3.RELEASE)
	
	2016-03-25 21:40:56.918  INFO 97120 --- [           main] demo.Application                         : Starting Application v0.0.1-SNAPSHOT on keryhudeMacBook-Pro.local with PID 97120 (/Users/hushuming/Desktop/git-repo/spring-amqp/spring-amqp/confirm-rabbit/target/confirm-rabbit-0.0.1-SNAPSHOT.jar started by hushuming in /Users/hushuming/Desktop/git-repo/spring-amqp/spring-amqp/confirm-rabbit)
	2016-03-25 21:40:56.922  INFO 97120 --- [           main] demo.Application                         : No active profile set, falling back to default profiles: default
	2016-03-25 21:40:57.035  INFO 97120 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@56b82db6: startup date [Fri Mar 25 21:40:57 CST 2016]; root of context hierarchy
	2016-03-25 21:40:58.179  INFO 97120 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'beanNameViewResolver' with a different definition: replacing [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration; factoryMethodName=beanNameViewResolver; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter; factoryMethodName=beanNameViewResolver; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter.class]]
	2016-03-25 21:40:58.786  INFO 97120 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.amqp.rabbit.annotation.RabbitBootstrapConfiguration' of type [class org.springframework.amqp.rabbit.annotation.RabbitBootstrapConfiguration$$EnhancerBySpringCGLIB$$a267791f] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
	2016-03-25 21:40:59.549  INFO 97120 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
	2016-03-25 21:40:59.568  INFO 97120 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
	2016-03-25 21:40:59.569  INFO 97120 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.0.32
	2016-03-25 21:40:59.732  INFO 97120 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	2016-03-25 21:40:59.732  INFO 97120 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2702 ms
	2016-03-25 21:41:00.373  INFO 97120 --- [ost-startStop-1] o.s.b.c.e.ServletRegistrationBean        : Mapping servlet: 'dispatcherServlet' to [/]
	2016-03-25 21:41:00.381  INFO 97120 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'metricFilter' to: [/*]
	2016-03-25 21:41:00.381  INFO 97120 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'characterEncodingFilter' to: [/*]
	2016-03-25 21:41:00.381  INFO 97120 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
	2016-03-25 21:41:00.382  INFO 97120 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'httpPutFormContentFilter' to: [/*]
	2016-03-25 21:41:00.382  INFO 97120 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'requestContextFilter' to: [/*]
	2016-03-25 21:41:00.382  INFO 97120 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'webRequestLoggingFilter' to: [/*]
	2016-03-25 21:41:00.382  INFO 97120 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'applicationContextIdFilter' to: [/*]
	2016-03-25 21:41:00.937  INFO 97120 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@56b82db6: startup date [Fri Mar 25 21:40:57 CST 2016]; root of context hierarchy
	2016-03-25 21:41:01.030  INFO 97120 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/s]}" onto public java.lang.String demo.rabbit.Send.send_topic()
	2016-03-25 21:41:01.034  INFO 97120 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
	2016-03-25 21:41:01.038  INFO 97120 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
	2016-03-25 21:41:01.096  INFO 97120 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	2016-03-25 21:41:01.096  INFO 97120 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	2016-03-25 21:41:01.167  INFO 97120 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	2016-03-25 21:41:01.824  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/mappings || /mappings.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 21:41:01.825  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/health || /health.json],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(java.security.Principal)
	2016-03-25 21:41:01.827  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)
	2016-03-25 21:41:01.827  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics || /metrics.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 21:41:01.828  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/beans || /beans.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 21:41:01.829  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/dump || /dump.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 21:41:01.831  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/configprops || /configprops.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 21:41:01.832  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 21:41:01.833  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/info || /info.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 21:41:01.834  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)
	2016-03-25 21:41:01.834  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env || /env.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 21:41:01.835  INFO 97120 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/trace || /trace.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	2016-03-25 21:41:02.050  INFO 97120 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
	2016-03-25 21:41:02.062  INFO 97120 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase -2147482648
	2016-03-25 21:41:02.062  INFO 97120 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 0
	2016-03-25 21:41:02.146  INFO 97120 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
	2016-03-25 21:41:02.270  INFO 97120 --- [cTaskExecutor-1] o.s.a.r.c.CachingConnectionFactory       : Created new connection: SimpleConnection@7d675477 [delegate=amqp://wfij@127.0.0.1:5672//wfij]
	2016-03-25 21:41:02.273  INFO 97120 --- [cTaskExecutor-1] o.s.amqp.rabbit.core.RabbitAdmin         : Auto-declaring a non-durable or auto-delete Exchange (confirm-exchange) durable:true, auto-delete:true. It will be deleted by the broker if it shuts down, and can be redeclared by closing and reopening the connection.
	2016-03-25 21:41:02.273  INFO 97120 --- [cTaskExecutor-1] o.s.amqp.rabbit.core.RabbitAdmin         : Auto-declaring a non-durable, auto-delete, or exclusive Queue (confirm-queue) durable:true, auto-delete:true, exclusive:false. It will be redeclared if the broker stops and is restarted while the connection factory is alive, but all messages will be lost.
	2016-03-25 21:41:02.505  INFO 97120 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
	2016-03-25 21:41:02.511  INFO 97120 --- [           main] demo.Application                         : Started Application in 6.302 seconds (JVM running for 6.912)
	2016-03-25 21:41:28.190  INFO 97120 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
	2016-03-25 21:41:28.191  INFO 97120 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
	2016-03-25 21:41:28.212  INFO 97120 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 21 ms
	this is the receive message --< hello >
	正在调用receive().print方法
	confirmCD.get() is : null
	result is : HELLO







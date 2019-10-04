# SpringBootLearning
学习SpringBoot的记录和成果  
1.SpringBootLearning-helloWorld  
2.SpringBootLearning-config  
3.SpringBootLearning-jdbc  
	&emsp;&emsp;3.1 yml文件中dataSource配置注意点  
		&emsp;&emsp;&emsp;&emsp;1)url:jdbc:mysql://localhost:3306/world?useUnicode=true&serverTimezone=GMT&characterEncoding=UTF-8&useSSL=false,要加上时区serverTimezone=GMT  
		&emsp;&emsp;&emsp;&emsp;2)要加上spring前缀,不然访问出错  
	&emsp;&emsp;3.2 修改RESTApi请求参数中的@PathVariable("id")为@RequestParam(value = "id") int id  
4.SpringBootLearning-jpa  
	&emsp;&emsp;4.1 yml文件中文件中要配置server:port在spring前面  
	&emsp;&emsp;4.2 Entity上加上这个注解@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})  
5.SpringBootLearning-beetSql  
	&emsp;&emsp;5.1 beetSql的优点  
	&emsp;&emsp;5.2 需要自己装配  
6.SpringBootLearning-mybatis  
	&emsp;&emsp;6.1 controller层如何支持JSON数据格式,现在只支持Mult-part格式的  
	7.SpringBootLearning-mybatis-tx mybatis开启声明式事务通过@Transactional  
	8.SpringBootLearning-redis  
	&emsp;&emsp;8.1注意数据源的配置问题和操作的方法,通过StringRedisTemplate和ValueOperations操作数据库  
	&emsp;&emsp;8.2注意使用logger打印日志,便于测试  
	9.SpringBootLearning-redis-MQ 使用redis实现消息队列的方式  
	&emsp;&emsp;9.1创建消息接收者  
	&emsp;&emsp;9.2注入消息接收者  
	&emsp;&emsp;9.3注入消息监听容器,入参是RedisConnectionFactory和MessageListenerAdapter,MessageListenerAdapter构造函数中设置消息监听对象和具体的方法  
	10.SpringBootLearning-swagger 利用swagger生成api文档,很强大的API文档生成工具  
	11.SpringBootLearning-cache 利用SpringBoot默认的cache进行测试  
	&emsp;&emsp;11.1在不使用其他第三方缓存依赖的时候，springboot自动采用ConcurrenMapCacheManager作为缓存管理器  
	&emsp;&emsp;11.2在启动类上添加@EnableCaching,在具体的方法上添加@Cacheable("")  	  
12.SpringBootLearning-scheduling task  
&emsp;&emsp;12.1在程序的入口加上@EnableScheduling注解  
&emsp;&emsp;12.2在定时方法上加@Scheduled注解  
&emsp;&emsp;&emsp;&emsp;@Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行  
&emsp;&emsp;&emsp;&emsp;@Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行  
&emsp;&emsp;&emsp;&emsp;@Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次  
&emsp;&emsp;&emsp;&emsp;@Scheduled(cron=” /5 “) ：通过cron表达式定义规则  
13.SpringBootLearning-restTemplate 利用restTemplate去消费一个服务  
14.SpringBootLearning-asynchronous 在springBoot中使用异步方法  
&emsp;&emsp;14.1要在启动类上添加@EnableAsync开启异步任务,并且配置AsyncConfigurerSupport，比如最大的线程池为2.  
&emsp;&emsp;14.2要在调用的异步方法上添加@Asyns注解，表明这是一个异步方法      
15.SpringBootLearning-uploadFile 利用springboot上传文件到服务器,目前存在上传问题  
&emsp;&emsp;15.1没有上传到指定目录  
&emsp;&emsp;15.2下载指定文件显示错误  
16.SpringBootLearning-validateForm 利用springboot在客户端进行校验,利用最新的模板spring-boot-starter-thymeleaf  
17.SpringBoot-submitForm 利用spring-boot-starter-thymeleaf进行提交表单，需要注意@GetMapping()和@PostMapping()的区别

	

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
	

# SpringBootLearning
学习SpringBoot的记录和成果
1.SpringBootLearning-helloWorld
2.SpringBootLearning-config  
3.SpringBootLearning-jdbc  
3.1 yml文件中dataSource配置注意点  
  1)url:jdbc:mysql://localhost:3306/world?useUnicode=true&serverTimezone=GMT&characterEncoding=UTF-8&useSSL=false,要加上时区serverTimezone=GMT  
  2)要加上spring前缀,不然访问出错  
3.2 修改RESTApi请求参数中的@PathVariable("id")为@RequestParam(value = "id") int id

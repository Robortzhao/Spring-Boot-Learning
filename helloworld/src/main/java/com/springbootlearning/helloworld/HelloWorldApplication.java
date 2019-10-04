package com.springbootlearning.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

    //测试CommandLineRunner中方法的执行时间
    //执行时间：会在SpringBoot容器加载之后执行，执行完成后项目启动成功
    public static void main(String[] args) {
        System.out.println("The service to start!");
        SpringApplication.run(HelloWorldApplication.class, args);
        System.out.println("The service has started!");
    }
}

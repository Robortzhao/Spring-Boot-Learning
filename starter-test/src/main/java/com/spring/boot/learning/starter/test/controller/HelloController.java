package com.spring.boot.learning.starter.test.controller;

import com.springbootlearning.starter.springbootlearning.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyanhai
 * @description TODO
 * @date 2019/10/25
 **/
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHelloSpringBootLearnig("RobortZhao");
    }
}

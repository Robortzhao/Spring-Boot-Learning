package com.springbootlearning.helloworld.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyanhai
 * @description 测试CommandLineRunner
 * @date 2019/10/4
 **/

@Component
@Order(2)
public class OrderRunnerTwo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The OrderRunnerTwo start to initialize...");
    }

}

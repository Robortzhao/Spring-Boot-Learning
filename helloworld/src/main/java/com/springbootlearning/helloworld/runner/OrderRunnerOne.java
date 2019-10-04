package com.springbootlearning.helloworld.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyanhai
 * @description 测试CommandLineRunner的执行顺序
 * @date 2019/10/4
 **/

@Component
@Order(1)
public class OrderRunnerOne implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The OrderRunnerOne start to initialize...");
    }

}

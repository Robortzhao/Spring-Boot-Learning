package com.spring.boot.learning.bootstrap.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyanhai
 * @description TODO
 * @date 2019/10/25
 **/

@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner run " + args);
    }
}

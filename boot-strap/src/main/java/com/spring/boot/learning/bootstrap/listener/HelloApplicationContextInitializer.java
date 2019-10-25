package com.spring.boot.learning.bootstrap.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhaoyanhai
 * @description TODO
 * @date 2019/10/25
 **/

public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ApplicationContextInitializer initialize finish!");
    }
}

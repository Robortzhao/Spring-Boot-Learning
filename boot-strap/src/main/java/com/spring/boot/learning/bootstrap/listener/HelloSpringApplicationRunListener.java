package com.spring.boot.learning.bootstrap.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author zhaoyanhai
 * @description TODO
 * @date 2019/10/25
 **/

public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

    public HelloSpringApplicationRunListener(SpringApplication application, String[] args) {


    }

    @Override
    public void starting() {
        System.out.println("HelloSpringApplicationRunListener starting!");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("HelloSpringApplicationRunListener environmentPrepared!  " + environment.getSystemProperties().get("os.name"));
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener contextPrepared!");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener contextLoaded!");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener started!");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener running!");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("HelloSpringApplicationRunListener failed!");
    }

}

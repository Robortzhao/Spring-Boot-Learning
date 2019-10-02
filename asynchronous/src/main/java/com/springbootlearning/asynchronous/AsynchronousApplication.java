package com.springbootlearning.asynchronous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class AsynchronousApplication extends AsyncConfigurerSupport {

    public static void main(String[] args) {
        SpringApplication.run(AsynchronousApplication.class, args);
    }

    /**
     * @return java.util.concurrent.Executor
     * @throws
     * @Description 设置异步线程
     * @author zhaoyanhai
     * @date 2019/10/3
     **/
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GitHubLookUp-");
        executor.initialize();
        return executor;
    }

}

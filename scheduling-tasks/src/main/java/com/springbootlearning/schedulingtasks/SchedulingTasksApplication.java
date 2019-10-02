package com.springbootlearning.schedulingtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class SchedulingTasksApplication {


    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulingTasksApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SchedulingTasksApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {
        return args -> {
            String quote = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", String.class);
            LOGGER.info(quote.toString());
        };
    }

}

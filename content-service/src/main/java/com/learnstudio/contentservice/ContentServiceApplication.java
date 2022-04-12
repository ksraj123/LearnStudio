package com.learnstudio.contentservice;

import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = { "com.learnstudio.contentservice" },
        exclude = { KafkaAutoConfiguration.class,
                RedisReactiveAutoConfiguration.class,
                RedissonAutoConfiguration.class })
@EnableJpaRepositories(basePackages= "com.learnstudio.contentservice.repository")
@EnableDiscoveryClient
@EnableRetry
@EnableHystrix
@EnableAsync
public class ContentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentServiceApplication.class, args);
    }

}

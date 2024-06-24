package com.tianyuchan.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringbootRabbitmqConsumerApplication
 *
 * @author tianyuchan
 * @since 2024/6/24
 */
@SpringBootApplication
@ComponentScan(value = "com.tianyuchan.service")
public class SpringbootRabbitmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqConsumerApplication.class, args);
        System.out.println("rabbitmq consumer start...");
    }

}

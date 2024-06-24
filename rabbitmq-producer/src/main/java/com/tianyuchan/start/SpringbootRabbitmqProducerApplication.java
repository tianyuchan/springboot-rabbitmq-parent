package com.tianyuchan.start;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringbootRabbitmqProducerApplication
 *
 * @author tianyuchan
 * @since 2024/6/24
 */
@SpringBootApplication
@ComponentScan(value = "com.tianyuchan.service")
public class SpringbootRabbitmqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqProducerApplication.class, args);
        System.out.println("rabbitmq producer start...");
    }

}

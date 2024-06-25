package com.tianyuchan.service;

import com.tianyuchan.start.SpringbootRabbitmqProducerApplication;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SimpleQueueProducerTest
 * 1.简单模式——发送消息
 *
 * @author tianyuchan
 * @since 2024/6/24
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqProducerApplication.class)
public class SimpleQueueProducerTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    private static final String QUEUE = "simple_queue";


    @Test
    public void send() {
        String msg = "Hello World: ";
        rabbitTemplate.convertAndSend(QUEUE, msg);
    }

}

/** 简单模式下，单一接收端接收消息
 * ====简单模式接收消息端====>Hello World: simple_queue
 */

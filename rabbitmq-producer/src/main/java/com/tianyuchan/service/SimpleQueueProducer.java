package com.tianyuchan.service;

import jakarta.annotation.Resource;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * SimpleQueueProducer
 * 1.简单模式——发送消息
 *
 * @author tianyuchan
 * @since 2024/6/24
 */

@Service
public class SimpleQueueProducer implements Producer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send() {
        String message = "Hello World";
        String queue = "simple_queue";
        rabbitTemplate.convertAndSend(queue, message);
    }

}

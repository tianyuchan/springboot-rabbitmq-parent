package com.tianyuchan.service;

import jakarta.annotation.Resource;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * WorkQueueProducer
 * 1.工作队列模式——发送消息
 *
 * @author tianyuchan
 * @since 2024/6/25
 */
@Service
public class WorkQueueProducer implements Producer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String msg) {
        String queue = "work_queue";
        rabbitTemplate.convertAndSend(queue, msg);
    }
}

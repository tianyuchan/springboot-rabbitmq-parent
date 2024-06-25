package com.tianyuchan.service;

import jakarta.annotation.Resource;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * PublishAndSubscribeProducer
 * 3.发布订阅模式——发送消息（广播到绑定到交换机的队列）
 *
 * @author tianyuchan
 * @since 2024/6/25
 */

@Service
public class PublishAndSubscribeProducer implements Producer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String msg) {
        String exchange = "fanout_exchange";
        rabbitTemplate.convertAndSend(exchange, "", msg);
    }
}

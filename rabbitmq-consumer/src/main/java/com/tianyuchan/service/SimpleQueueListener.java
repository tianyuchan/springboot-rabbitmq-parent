package com.tianyuchan.service;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * SimpleQueueListener
 * 1.简单模式——接收消息
 *
 * @author tianyuchan
 * @since 2024/6/24
 */

@Component
@RabbitListener(queues = "simple_queue")
public class SimpleQueueListener implements Consumer {


    @Override
    @RabbitHandler
    public void handle(String msg) {
        System.out.println("====接收消息====>" + msg);
    }
}

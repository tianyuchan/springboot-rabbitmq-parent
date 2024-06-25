package com.tianyuchan.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * WorkQueueListener
 * 1.简单队列模式——接收消息
 *
 * @author tianyuchan
 * @since 2024/6/25
 */
@Component
@RabbitListener(queues = "work_queue")
public class WorkQueueListener implements Consumer {

    @Override
    @RabbitHandler
    public void handle(String msg) {
        System.out.println("====工作队列消息接收端1====>" + msg);
    }
}

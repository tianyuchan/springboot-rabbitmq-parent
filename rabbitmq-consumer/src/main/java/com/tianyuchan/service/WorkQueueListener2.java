package com.tianyuchan.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * WorkQueueListener
 * 2.工作队列模式——消息接收端2
 *
 * @author tianyuchan
 * @since 2024/6/25
 */
@Component
@RabbitListener(queues = "work_queue")
public class WorkQueueListener2 implements Consumer {

    @Override
    @RabbitHandler
    public void handle(String msg) {
        System.out.println("====工作队列模式消息接收端2====>" + msg);
    }

}

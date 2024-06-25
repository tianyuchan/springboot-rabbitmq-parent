package com.tianyuchan.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * PublishAndSubscribeConsumer
 * 3.发布订阅模式——消息接收端2
 *
 * @author tianyuchan
 * @since 2024/6/25
 */

@Component
@RabbitListener(queues = "fanout_queue2")
public class PublishAndSubscribeConsumer2 implements Consumer {

    @Override
    @RabbitHandler
    public void handle(String msg) {
        System.out.println("====发布订阅模式消息接收端2====>" + msg + "fanout_queue2");
    }

}

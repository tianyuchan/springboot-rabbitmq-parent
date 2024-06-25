package com.tianyuchan.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TopicModeConsumer
 * 5.主题模式——消息接收端2
 *
 * @author tianyuchan
 * @since 2024/6/25
 */

@Component
@RabbitListener(queues = "topic_queue2")
public class TopicModeConsumer2 implements Consumer {

    @Override
    @RabbitHandler
    public void handle(String msg) {
        System.out.println("====主题模式消息接收端2====>" + msg + "topic_queue2");
    }
}

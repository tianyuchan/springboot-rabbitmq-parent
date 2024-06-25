package com.tianyuchan.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TopicModeConsumer
 * 5.主题模式——消息接收端1
 *
 * @author tianyuchan
 * @since 2024/6/25
 */

@Component
@RabbitListener(queues = "topic_queue1")
public class TopicModeConsumer implements Consumer {

    @Override
    @RabbitHandler
    public void handle(String msg) {
        System.out.println("====主题模式消息接收端1====>" + msg + "topic_queue1");
    }
}

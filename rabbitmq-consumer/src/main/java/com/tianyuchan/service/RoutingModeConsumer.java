package com.tianyuchan.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RoutingModeConsumer
 * 4.路由模式——消息接收端1
 *
 * @author tianyuchan
 * @since 2024/6/25
 */

@Component
@RabbitListener(queues = "direct_queue1")
public class RoutingModeConsumer implements Consumer {

    @Override
    @RabbitHandler
    public void handle(String msg) {
        System.out.println("====路由模式消息接收端1====>" + msg + "direct_queue1");
    }

}

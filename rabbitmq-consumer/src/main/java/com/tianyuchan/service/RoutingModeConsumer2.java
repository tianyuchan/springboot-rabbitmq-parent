package com.tianyuchan.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RoutingModeConsumer
 * 4.路由模式——消息接收端2
 *
 * @author tianyuchan
 * @since 2024/6/25
 */

@Component
@RabbitListener(queues = "direct_queue2")
public class RoutingModeConsumer2 implements Consumer {

    @Override
    @RabbitHandler
    public void handle(String msg) {
        System.out.println("====路由模式消息接收端2====>" + msg + "direct_queue2");
    }

}

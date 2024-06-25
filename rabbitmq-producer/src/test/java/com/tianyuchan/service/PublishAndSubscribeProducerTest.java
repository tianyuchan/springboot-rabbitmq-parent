package com.tianyuchan.service;

import com.tianyuchan.start.SpringbootRabbitmqProducerApplication;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RoutingModeProducerTest
 * 3.发布订阅模式——发送消息
 *
 * @author tianyuchan
 * @since 2024/6/25
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqProducerApplication.class)
class PublishAndSubscribeProducerTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "fanout_exchange";


    @Test
    void send() {
        String msg = "Hello World: fanout_exchange==>";
        rabbitTemplate.convertAndSend(EXCHANGE, "", msg);
    }
}

/** 发布订阅模式下，消息会被广播到绑定到交换机的所有队列
 * ====发布订阅模式消息接收端1====>Hello World: fanout_exchange==>fanout_queue1
 * ====发布订阅模式消息接收端2====>Hello World: fanout_exchange==>fanout_queue2
 */
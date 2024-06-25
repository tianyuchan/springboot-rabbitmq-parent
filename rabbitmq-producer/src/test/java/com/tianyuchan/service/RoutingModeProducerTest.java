package com.tianyuchan.service;

import com.tianyuchan.start.SpringbootRabbitmqProducerApplication;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RoutingModeProducerTest
 * 4.路由模式——发送消息
 *
 * @author tianyuchan
 * @since 2024/6/25
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqProducerApplication.class)
public class RoutingModeProducerTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "direct_exchange";
    private static final String ROUTING_KEY_1 = "routing_key1";
    private static final String ROUTING_KEY_2 = "routing_key2";


    @Test
    public void send() {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_1, "Hello World: direct_exchange==routing_key1==>");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_2, "Hello World: direct_exchange==routing_key2==>");
    }

}


/** 路由模式下，通过路由key将消息转发至指定队列
 * ====路由模式消息接收端1====>Hello World: direct_exchange==routing_key1==>direct_queue1
 * ====路由模式消息接收端2====>Hello World: direct_exchange==routing_key2==>direct_queue2
 */

package com.tianyuchan.service;

import com.tianyuchan.start.SpringbootRabbitmqProducerApplication;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TopicModeProducerTest
 * 5.主题模式——发送消息
 *
 * @author tianyuchan
 * @since 2024/6/25
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqProducerApplication.class)
public class TopicModeProducerTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "topic_exchange";

    @Test
    public void send() {
        String routing_key1 = "item.send";
        rabbitTemplate.convertAndSend(EXCHANGE, routing_key1, "Hello World: topic_exchange==item.send==>");
        String routing_key2 = "item.send.abc";
        rabbitTemplate.convertAndSend(EXCHANGE, routing_key2, "Hello World: topic_exchange==item.send.abc==>");
    }

}

/** 主题模式下，绑定路由键中"*"表示匹配一个词，"#"标识匹配多个词
 *  item.* 仅可以匹配到 item.send
 *  item.# 可以同时匹配到 item.send 和 item.send.abc
 * ====主题模式消息接收端2====>Hello World: topic_exchange==item.send==>topic_queue2
 * ====主题模式消息接收端1====>Hello World: topic_exchange==item.send==>topic_queue1
 * ====主题模式消息接收端2====>Hello World: topic_exchange==item.send.abc==>topic_queue2
 */

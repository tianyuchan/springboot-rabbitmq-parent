package com.tianyuchan.service;

import com.tianyuchan.start.SpringbootRabbitmqProducerApplication;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqProducerApplication.class)
class PublishAndSubscribeProducerTest {

    @Resource
    private PublishAndSubscribeProducer producer;

    @Test
    void send() {
        producer.send("Hello PublishAndSubscribe");
    }
}

/** 发布订阅模式下，消息会被广播到绑定到交换机的所有队列
 * ====发布订阅模式消息接收端2====>Hello PublishAndSubscribe
 * ====发布订阅模式消息接收端1====>Hello PublishAndSubscribe
 */
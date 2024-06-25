package com.tianyuchan.service;

import com.tianyuchan.start.SpringbootRabbitmqProducerApplication;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqProducerApplication.class)
class WorkQueueProducerTest {

    @Resource
    private WorkQueueProducer workQueueProducer;

    @Test
    void send() {
        // 向工作队列发送10条消息
        for (int i = 0; i < 10; i++) {
            workQueueProducer.send("Hello World 【" + i + "】");
        }
    }

}

/** 工作队列模式下，各个消费端是竞争关系
 * ====工作队列消息接收端2====>Hello World 【1】
 * ====工作队列消息接收端1====>Hello World 【0】
 * ====工作队列消息接收端1====>Hello World 【2】
 * ====工作队列消息接收端2====>Hello World 【3】
 * ====工作队列消息接收端1====>Hello World 【4】
 * ====工作队列消息接收端2====>Hello World 【5】
 * ====工作队列消息接收端1====>Hello World 【6】
 * ====工作队列消息接收端2====>Hello World 【7】
 * ====工作队列消息接收端1====>Hello World 【8】
 * ====工作队列消息接收端2====>Hello World 【9】
 */
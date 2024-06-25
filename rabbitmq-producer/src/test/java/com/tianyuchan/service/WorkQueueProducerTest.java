package com.tianyuchan.service;

import com.tianyuchan.start.SpringbootRabbitmqProducerApplication;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * WorkQueueProducerTest
 * 2.工作队列模式——发送消息
 *
 * @author tianyuchan
 * @since 2024/6/24
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqProducerApplication.class)
class WorkQueueProducerTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    private static final String QUEUE = "work_queue";


    @Test
    void send() {
        // 向工作队列发送10条消息
        for (int i = 0; i < 10; i++) {
            String msg = "Hello World 【" + i + "】: ";
            rabbitTemplate.convertAndSend(QUEUE, msg);
        }
    }

}

/** 工作队列模式下，各个消费端竞争接收消息
 * ====工作队列模式消息接收端1====>Hello World 【0】: work_queue
 * ====工作队列模式消息接收端2====>Hello World 【1】: work_queue
 * ====工作队列模式消息接收端1====>Hello World 【2】: work_queue
 * ====工作队列模式消息接收端2====>Hello World 【3】: work_queue
 * ====工作队列模式消息接收端1====>Hello World 【4】: work_queue
 * ====工作队列模式消息接收端1====>Hello World 【6】: work_queue
 * ====工作队列模式消息接收端1====>Hello World 【8】: work_queue
 * ====工作队列模式消息接收端2====>Hello World 【5】: work_queue
 * ====工作队列模式消息接收端2====>Hello World 【7】: work_queue
 * ====工作队列模式消息接收端2====>Hello World 【9】: work_queue
 */
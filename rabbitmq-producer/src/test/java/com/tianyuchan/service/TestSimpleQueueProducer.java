package com.tianyuchan.service;

import com.tianyuchan.start.SpringbootRabbitmqProducerApplication;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TestSimpleQueue
 *
 * @author tianyuchan
 * @since 2024/6/24
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqProducerApplication.class)
public class TestSimpleQueueProducer {

    @Resource
    private SimpleQueueProducer simpleQueueProducer;

    @Test
    public void send() {
        simpleQueueProducer.send();
    }
}

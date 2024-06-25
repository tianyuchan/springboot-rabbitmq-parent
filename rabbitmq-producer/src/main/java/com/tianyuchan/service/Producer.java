package com.tianyuchan.service;

/**
 * Producer
 * 生产者
 *
 * @author tianyuchan
 * @since 2024/6/24
 */

public interface Producer {

    /**
     * 发送消息
     */
    void send(String msg);
}

package com.tianyuchan.service;

/**
 * Consumer
 * 消费者
 *
 * @author tianyuchan
 * @since 2024/6/24
 */

public interface Consumer {

    /**
     * 消费消息
     * @param msg 消息字符串
     */
    void handle(String msg);
}

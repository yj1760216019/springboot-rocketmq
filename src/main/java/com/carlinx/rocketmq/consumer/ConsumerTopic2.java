package com.carlinx.rocketmq.consumer;

import cn.hutool.json.JSONUtil;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author yj
 * @Create 2019/11/15 9:44
 */

@Service
@RocketMQMessageListener(topic = "carlinx-test-topic2",consumerGroup = "group2")
public class ConsumerTopic2 implements RocketMQListener<List> {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerTopic2.class);

    @Override
    public void onMessage(List message) {
        for (Object o : message) {
            System.out.println(o);
        }
        logger.info("主题:topic2  消费组:group2  消费的消息{}",message);
    }
}

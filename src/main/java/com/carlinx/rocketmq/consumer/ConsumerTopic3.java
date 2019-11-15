package com.carlinx.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yj
 * @Create 2019/11/15 10:19
 */

@Service
@RocketMQMessageListener(topic = "carlinx-test-topic2",consumerGroup = "group3")
public class ConsumerTopic3 implements RocketMQListener<List> {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerTopic3.class);


    @Override
    public void onMessage(List message) {
        for (Object o : message) {
            System.out.println(o);
        }
        logger.info("主题:topic2  消费组:group3  消费到的消息:{}",message);
    }
}

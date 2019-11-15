package com.carlinx.rocketmq.consumer;

import com.carlinx.rocketmq.entity.Message;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @Author yj
 * @Create 2019/11/15 8:42
 */


@Service
@RocketMQMessageListener(topic = "carlinx-test-topic1",consumerGroup = "group1",consumeMode = ConsumeMode.ORDERLY)
public class ConsumerTopic1 implements RocketMQListener<Message> {
    private static Logger logger  = LoggerFactory.getLogger(ConsumerTopic1.class);


    @Override
    public void onMessage(Message message) {
        logger.info("主题:topic1  消费组:group1  消费的消息:{}",message);
    }
}

package com.carlinx.rocketmq.producer;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.carlinx.rocketmq.entity.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author yj
 * @Create 2019/11/15 8:42
 */

@Service
public class Producer{
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    public void sendTopic1(Message message){
        logger.info("topic1 开始发送消息");
        rocketMQTemplate.convertAndSend("carlinx-test-topic1",message);
        logger.info("topic1 发送的消息为:{}",message);
    }


    public void sendTopic2(){
        logger.info("topic2 开始发送消息");
        rocketMQTemplate.send("carlinx-test-topic2",MessageBuilder.withPayload(Arrays.asList("中国","浙江","杭州","滨江区")).build());
    }

    public void sendTopic3(){
        logger.info("topic3 开始发送消息");
        Map<String, Object> map = new HashMap<>();
        map.put(MessageHeaders.TIMESTAMP, DateUtil.currentSeconds());
        org.springframework.messaging.Message<List<String>> message = MessageBuilder.createMessage(Arrays.asList("中国", "河北", "邢台", "沙河"), new MessageHeaders(map));
        rocketMQTemplate.send("carlinx-test-topic3",message);
    }



}

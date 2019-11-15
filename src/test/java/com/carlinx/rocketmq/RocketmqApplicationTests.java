package com.carlinx.rocketmq;

import com.carlinx.rocketmq.entity.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RocketmqApplicationTests {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void contextLoads() {
        String name = "aa";
        rocketMQTemplate.convertAndSend("test-topic-2",name);
        rocketMQTemplate.send("test-topic-2", MessageBuilder.withPayload(Arrays.asList("aa","bb","cc")).build());
        System.out.println("发送成功");
    }



    @Test
    public void test2(){
        Message<String> message = new Message<>("1","yj");
        String id = message.getId();
        System.out.println(id);
    }



}

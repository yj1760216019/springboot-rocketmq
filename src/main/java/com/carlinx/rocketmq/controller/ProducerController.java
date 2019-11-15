package com.carlinx.rocketmq.controller;

import com.carlinx.rocketmq.entity.Message;
import com.carlinx.rocketmq.producer.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yj
 * @Create 2019/11/15 9:49
 */


@RestController("/api/produce")
@Api(value = "生产消息")
public class ProducerController {
    @Autowired
    private Producer producer;


    @PostMapping("/topic1")
    @ApiOperation("topic1")
    public String produceTopic1(@RequestBody Message message){
        producer.sendTopic1(message);
        return "success";
    }



    @PostMapping("/topic2")
    @ApiOperation("topic2")
    public String producerTopic2(){
        producer.sendTopic2();
        return "success";
    }
}

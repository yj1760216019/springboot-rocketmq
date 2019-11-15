package com.carlinx.rocketmq.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @Author yj
 * @Create 2019/11/15 8:51
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("消息实体")
public class Message<T> implements Serializable {
    @ApiModelProperty(value = "消息id",dataType = "String")
    private String id;
    @ApiModelProperty(value = "消息体",dataType = "Object")
    private T content;
}

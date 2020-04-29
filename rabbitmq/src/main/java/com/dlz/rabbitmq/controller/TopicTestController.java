package com.dlz.rabbitmq.controller;

import com.dlz.rabbitmq.enums.ExchangeEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class TopicTestController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sendTopicMessage")
    public String sendDirectMessage(String msg){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msgId", UUID.randomUUID());
        map.put("msgData",msg);
        map.put("sendTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        rabbitTemplate.convertAndSend(ExchangeEnum.EXCHANGE_3.name, "topic.man",map);
        return "OK";
    }
}

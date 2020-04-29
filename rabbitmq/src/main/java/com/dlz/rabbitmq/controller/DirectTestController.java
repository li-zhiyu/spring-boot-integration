package com.dlz.rabbitmq.controller;

import com.dlz.rabbitmq.enums.ExchangeEnum;
import com.dlz.rabbitmq.enums.RouteKeyEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class DirectTestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sendDirectMessage")
    public String sendDirectMessage(String msg){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msgId", UUID.randomUUID());
        map.put("msgData",msg);
        map.put("sendTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        rabbitTemplate.convertAndSend(ExchangeEnum.EXCHANGE_1.name, RouteKeyEnum.ROUTEKEY_2.name,map);
        return "OK";
    }
}

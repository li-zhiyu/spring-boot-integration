package com.dlz.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RabbitListener(queues = {"queue1","queue2","queue3"})
public class DirectConsumer {
    public static final Logger log = LoggerFactory.getLogger(DirectConsumer.class);

    @RabbitHandler
    public void process(Map obj, Channel channel, Message message) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        log.info("qqq接收到的消息为：{}",obj.toString());

    }
}



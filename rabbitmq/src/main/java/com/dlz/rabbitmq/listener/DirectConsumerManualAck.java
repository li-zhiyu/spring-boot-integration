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
@RabbitListener(queues = "queue3")
public class DirectConsumerManualAck {
    public static final Logger log = LoggerFactory.getLogger(DirectConsumer.class);

    @RabbitHandler
    public void process(Map obj, Channel channel, Message message) throws IOException {
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);//true-表示消费成功后回复ACK，false-表示消费成功后不回复ACK
            log.info("接收到的消息为：{}",obj.toString());

        } catch (IOException e) {
            e.printStackTrace();
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);//true-消费不成功将消息重新加入队列，false-消费不成功将消息丢弃
        }


    }
}

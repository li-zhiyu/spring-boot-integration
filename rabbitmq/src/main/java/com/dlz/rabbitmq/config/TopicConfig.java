package com.dlz.rabbitmq.config;

import com.dlz.rabbitmq.enums.ExchangeEnum;
import com.dlz.rabbitmq.enums.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    /**
     *创建交换机
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(ExchangeEnum.EXCHANGE_3.name);
    }
    /**
     *创建队列
     */
    @Bean
    public Queue topicqueue1(){
        return new Queue(QueueEnum.QUEUE_1.name,true);
    }
    @Bean
    public Queue topicqueue2(){
        return new Queue(QueueEnum.QUEUE_2.name,true);
    }
    @Bean
    public Queue topicqueue3(){
        return new Queue(QueueEnum.QUEUE_3.name,true);
    }
    /**
     *绑定交换机跟队列(Topic模式)
     */
    @Bean
    public Binding bindingTopic(){
        return BindingBuilder.bind(topicqueue3()).to(topicExchange()).with("topic.#");
    }
}

package com.dlz.rabbitmq.config;

import com.dlz.rabbitmq.enums.ExchangeEnum;
import com.dlz.rabbitmq.enums.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    /**
     *创建交换机
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(ExchangeEnum.EXCHANGE_2.name);
    }
    /**
     *创建队列
     */
    @Bean
    public Queue fanoutqueue1(){
        return new Queue(QueueEnum.QUEUE_1.name,true);
    }
    @Bean
    public Queue fanoutqueue2(){
        return new Queue(QueueEnum.QUEUE_2.name,true);
    }
    @Bean
    public Queue fanoutqueue3(){
        return new Queue(QueueEnum.QUEUE_3.name,true);
    }

    /**
     *绑定交换机跟队列(Fount模式)
     * Fount模式队列不需要绑定routekey
     */
    @Bean
    public Binding bindingFanout1(){
        return BindingBuilder.bind(fanoutqueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanout2(){
        return BindingBuilder.bind(fanoutqueue2()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanout3(){
        return BindingBuilder.bind(fanoutqueue3()).to(fanoutExchange());
    }
}

package com.dlz.rabbitmq.config;

import com.dlz.rabbitmq.enums.ExchangeEnum;
import com.dlz.rabbitmq.enums.QueueEnum;
import com.dlz.rabbitmq.enums.RouteKeyEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 交换机的几种模式：
 * direct:一对一
 * fanout:一对多
 * topic:模式匹配
 *
 * 一个监听器绑定到一个队列，消息到达队列，监听器既可以消费
 * 多个监听器绑定到一个队列，谁抢到谁消费
 *
 * direct：一个交换机上绑定一个队列，队列指定routekey，发送者指定交换机和routekey
 * fanout：一个交换机上绑定多个队列，队列不指定routkey，发送者指定交换机
 * topic:在direct基础上的主题模式匹配
 */
@Configuration
public class DirectConfig {
    /**
     *创建交换机
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(ExchangeEnum.EXCHANGE_1.name);
    }
    /**
     *创建队列
     */
    @Bean
    public Queue directqueue1(){
        return new Queue(QueueEnum.QUEUE_1.name,true);
    }
    @Bean
    public Queue directqueue2(){
        return new Queue(QueueEnum.QUEUE_2.name,true);
    }
    @Bean
    public Queue directqueue3(){
        return new Queue(QueueEnum.QUEUE_3.name,true);
    }
    /**
     *绑定交换机跟队列(Direct模式)
     */
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(directqueue2()).to(directExchange()).with(RouteKeyEnum.ROUTEKEY_2.name);
    }

}

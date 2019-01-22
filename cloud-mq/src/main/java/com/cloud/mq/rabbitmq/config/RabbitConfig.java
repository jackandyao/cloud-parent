package com.cloud.mq.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    /**
     * 创建一个队列--类似于rocketmq kafka的topic
     * @return
     */
     public Queue queue(){
         return new Queue("user-log");
     }
}

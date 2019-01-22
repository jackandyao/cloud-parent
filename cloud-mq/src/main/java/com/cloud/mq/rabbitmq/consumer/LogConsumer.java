package com.cloud.mq.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = {"user-log"})
public class LogConsumer {
    @RabbitHandler
    public void logConsumer(String log){
        System.out.println("消费数据:"+log);
    }
}

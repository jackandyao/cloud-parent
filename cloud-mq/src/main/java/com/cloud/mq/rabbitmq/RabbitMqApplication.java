package com.cloud.mq.rabbitmq;

import com.cloud.mq.rabbitmq.producer.LogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class RabbitMqApplication {
    @Autowired
    private LogProducer logProducer;
    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            //调用消息发送类中的消息发送方法
            logProducer.sendLog(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class,args);
    }
}

package com.cloud.mq.rabbitmq.producer;

import com.alibaba.fastjson.JSON;
import com.cloud.mq.kafka.log.UserLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LogProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     * @param userid
     */
    public void sendLog(String userid){
        UserLog userLog = new UserLog();
        userLog.setUsername("jhp").setUserid(userid).setState("0");
        System.err.println("发送用户日志数据:"+userLog);
        amqpTemplate.convertAndSend("user-log",JSON.toJSONString(userLog));
    }
}

package com.order.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述 订单rest服务启动入口
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class OrderRestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderRestApiApplication.class,args);
    }
}

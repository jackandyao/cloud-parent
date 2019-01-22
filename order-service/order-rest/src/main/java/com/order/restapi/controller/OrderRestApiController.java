package com.order.restapi.controller;

import com.google.gson.Gson;
import com.order.domain.entity.Order;
import com.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述
 */
@RestController
@RequestMapping("/order")
public class OrderRestApiController {

    @Autowired
    private OrderService orderService;

    /**
     * 根据订单id查询订单详情
     */
    @RequestMapping(value="/{orderid}")
    public CompletableFuture<Order>findOrder(@PathVariable long orderid){
        return CompletableFuture.supplyAsync(()->{
            Order order = orderService.findOrder(orderid);
            System.err.println("订单id:"+orderid+","+order);
            return order;
        });
    }


    /**
     * 根据订单的用户id,查询所有对应的订单信息
     */

    @RequestMapping(value = "/findOrders")
    public CompletableFuture<List<Order>>findOrders(@RequestParam long orderuserid){
        return CompletableFuture.supplyAsync(()->{
            List<Order> orders = orderService.findOrders(orderuserid);
            System.err.println("userid:"+orderuserid+",查询到"+orders.size()+"条记录...");
            return orders;

        });
    }
}

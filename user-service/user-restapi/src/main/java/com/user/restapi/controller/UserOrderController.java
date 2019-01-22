package com.user.restapi.controller;

import com.user.client.future.UserOrderFuture;
import com.user.entity.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述
 */
@RestController
@RequestMapping("/user")
public class UserOrderController {

    @Autowired
    private UserOrderFuture userOrderFuture;

    @RequestMapping(value="/{orderid}")
    public CompletableFuture<UserOrder> findOrder(@PathVariable long orderid){
        return userOrderFuture.findOrder(orderid);
    }
}

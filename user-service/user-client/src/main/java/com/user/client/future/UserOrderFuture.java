package com.user.client.future;

import com.user.client.service.UserOrderFallBackService;
import com.user.entity.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述 使用高并发驱事件编程 相比传统的编程方式 qps可以提高10倍以上
 */
@Component
public class UserOrderFuture {

    @Autowired
    private UserOrderFallBackService userOrderFallBackService;

    public CompletableFuture<UserOrder> findOrder(long orderid){
        return CompletableFuture.supplyAsync(()->{
            UserOrder userOrder = userOrderFallBackService.findOrder(orderid);
            System.err.println("用户订单id,"+orderid+":"+userOrder);
            return userOrder;
        });
    }
}

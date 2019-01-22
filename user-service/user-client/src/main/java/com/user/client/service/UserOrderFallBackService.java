package com.user.client.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.user.client.fegion.UserOrderFegion;
import com.user.client.util.JsonUtils;
import com.user.entity.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述
 */
@Service
public class UserOrderFallBackService {

    @Autowired
    private UserOrderFegion userOrderFegion;

    @HystrixCommand(fallbackMethod = "findOrderFallback")
    public UserOrder findOrder(long orderid){
        String order = userOrderFegion.findOrder(orderid);
        JsonNode jsonNode = JsonUtils.str2JsonNode(order);
        UserOrder userOrder = new UserOrder();
        userOrder.setLoginName("jiahp");
        userOrder.setOrderid(Long.parseLong(jsonNode.get("ordid").toString()));
        userOrder.setProductId(jsonNode.get("productId").toString());
        userOrder.setPrice(Double.parseDouble(jsonNode.get("price").toString()));
        userOrder.setUserid(Long.parseLong(jsonNode.get("userid").toString()));
        userOrder.setStatus(Integer.parseInt(jsonNode.get("status").toString())==0?"未支付":"已支付");
        return userOrder;
    }

    /**
     * 服务降级方法
     * @param orderid
     * @return
     */
    private UserOrder findOrderFallback(long orderid){
        UserOrder userOrder = new UserOrder();
        userOrder.setLoginName("jiahp");
        userOrder.setOrderid(001);
        userOrder.setProductId("1002");
        userOrder.setPrice(100);
        userOrder.setUserid(1001);
        userOrder.setStatus("订单异常");
        return userOrder;
    }
}

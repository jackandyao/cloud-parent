package com.order.domain.service;

import com.order.domain.entity.Order;

import java.util.List;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述 订单服务接口
 */
public interface IOrderService {
    /**
     * 根据用户id 查询所有订单信息
     * @param userid
     * @return
     */
    List<Order>findOrders(long userid);

    /**
     * 根据订单id 查询指定订单信息
     * @param orderid
     * @return
     */
    Order findOrder(long orderid);
}

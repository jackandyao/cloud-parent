package com.order.domain.service;

import com.order.domain.entity.Order;
import com.order.domain.reposity.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述 订单服务接口实现+缓存实现
 */
@Service
public class OrderService implements IOrderService{

    public static final String CACHE_NAME ="order";

    @Autowired
    private OrderRepository orderRepository;

    @Cacheable(value = CACHE_NAME,key = "'order_'+#userid")
    @Override
    public List<Order> findOrders(long userid) {
        return orderRepository.findOrdersByUserid(userid);
    }

    @Cacheable(value = CACHE_NAME,key = "'order_'+#orderid")
    @Override
    public Order findOrder(long orderid) {
        return orderRepository.findOrder(orderid);
    }
}

package com.order.domain.reposity;
import com.order.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述 订单数据访问层接口
 */
@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    /**
     * 根据用户id 查询所有订单信息
     * @param orderUserId
     * @return
     */
    List<Order> findOrdersByUserid(long orderUserId);

    /**
     * 根据订单id 查询指定订单信息
     * @param orderid
     * @return
     */
    Order findOrder(long orderid);
}

package com.user.client.fegion;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述
 */
@FeignClient("orderapi")
public interface UserOrderFegion {
    /**
     * 根据订单id 查询订单详情
     */
    @GetMapping(value = "/order/{id}")
    String findOrder(@PathVariable long orderid);

}

package com.order.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述  用来封装页面传递过来的订单请求参数
 */
@Data
@Getter
@Setter
@EqualsAndHashCode
public class OrderVO  {
    /**
     * 订单id
     */
    private long orderid;
    /**
     * 订单状态
     */
    private long status;
    /**
     * 订单-用户id
     */
    private long orderUserId;
    /**
     * 产品ID
     */
    private String productId;

    /**
     * 订单价格
     */
    private double price;



}

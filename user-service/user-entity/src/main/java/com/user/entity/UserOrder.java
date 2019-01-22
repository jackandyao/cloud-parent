package com.user.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述 伪装用户订单综合信息
 */
@Data
@Getter
@Setter
@ToString
public class UserOrder implements Serializable {

    /**
     * 订单id
     */
    private long orderid;
    /**
     * 订单状态
     */

    private String status;
    /**
     * 订单-用户id
     */

    private long userid;
    /**
     * 产品ID
     */

    private String productId;

    /**
     * 订单价格
     */

    private double price;

    /**
     * 用户姓名
     */
    private String loginName;
}

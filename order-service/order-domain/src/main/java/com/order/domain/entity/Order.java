package com.order.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述
 */
@Data
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "order")
@Entity
public class Order implements Serializable {

    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderid;
    /**
     * 订单状态
     */
    @Column(name="status")
    private long status;
    /**
     * 订单-用户id
     */
    @Column(name="orderUserId")
    private long orderUserId;
    /**
     * 产品ID
     */
    @Column(name="productId")
    private String productId;

    /**
     * 订单价格
     */
    @Column(name="price")
    private double price;

}

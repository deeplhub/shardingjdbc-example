package com.xh.shardingjdbc.example.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author H.Yang
 * @since 2022-10-10
 */
@Getter
@Setter
@TableName("product_order_item")
public class ProductOrderItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 订单号
     */
    @TableField("product_order_id")
    private String productOrderId;

    /**
     * 产品id
     */
    @TableField("product_id")
    private String productId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;


}

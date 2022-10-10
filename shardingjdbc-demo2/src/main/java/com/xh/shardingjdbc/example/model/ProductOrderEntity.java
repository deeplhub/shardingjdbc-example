package com.xh.shardingjdbc.example.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

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
@TableName("product_order")
public class ProductOrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 订单唯一标识
     */
    @TableField("trade_no")
    private String tradeNo;

    /**
     * NEW 未支付订单,PAY已经支付订单,CANCEL超时取消订单
     */
    @TableField("state")
    private String state;

    /**
     * 订单生成时间
     */
    @TableField("create_at")
    private Date createAt;

    /**
     * 订单实际支付价格
     */
    @TableField("pay_amount")
    private BigDecimal payAmount;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;


}

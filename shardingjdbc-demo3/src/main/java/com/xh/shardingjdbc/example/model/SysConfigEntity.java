package com.xh.shardingjdbc.example.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author H.Yang
 * @since 2022-09-28
 */
@Getter
@Setter
@TableName("sys_config")
public class SysConfigEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 配置key
     */
    @TableField("`key`")
    private String key;

    /**
     * 配置value
     */
    @TableField("`value`")
    private String value;

    /**
     * 类型
     */
    @TableField("`type`")
    private String type;


}

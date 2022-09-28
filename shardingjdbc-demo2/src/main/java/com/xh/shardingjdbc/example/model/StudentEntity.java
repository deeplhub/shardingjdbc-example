package com.xh.shardingjdbc.example.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author H.Yang
 * @since 2022-09-21
 */
@Getter
@Setter
@TableName("student")
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("sex")
    private Boolean sex;

    @TableField("phone")
    private String phone;

    @TableField("tel")
    private String tel;

    @TableField("create_at")
    private Date createAt;


}

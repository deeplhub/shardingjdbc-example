package com.xh.shardingjdbc.example.mapper;

import com.xh.shardingjdbc.example.model.ProductOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author H.Yang
 * @since 2022-10-10
 */
@Mapper
public interface ProductOrderMapper extends BaseMapper<ProductOrderEntity> {

}

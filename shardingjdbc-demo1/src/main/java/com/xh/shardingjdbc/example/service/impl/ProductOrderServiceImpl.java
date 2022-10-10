package com.xh.shardingjdbc.example.service.impl;

import com.xh.shardingjdbc.example.model.ProductOrderEntity;
import com.xh.shardingjdbc.example.mapper.ProductOrderMapper;
import com.xh.shardingjdbc.example.service.ProductOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author H.Yang
 * @since 2022-10-10
 */
@Service
public class ProductOrderServiceImpl extends ServiceImpl<ProductOrderMapper, ProductOrderEntity> implements ProductOrderService {

}

package com.xh.shardingjdbc.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.shardingjdbc.example.mapper.ProductOrderItemMapper;
import com.xh.shardingjdbc.example.mapper.ProductOrderMapper;
import com.xh.shardingjdbc.example.model.ProductOrderEntity;
import com.xh.shardingjdbc.example.model.ProductOrderItemEntity;
import com.xh.shardingjdbc.example.service.ProductOrderItemService;
import com.xh.shardingjdbc.example.service.ProductOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author H.Yang
 * @since 2022-10-10
 */
@Service
public class ProductOrderItemServiceImpl extends ServiceImpl<ProductOrderItemMapper, ProductOrderItemEntity> implements ProductOrderItemService {

}

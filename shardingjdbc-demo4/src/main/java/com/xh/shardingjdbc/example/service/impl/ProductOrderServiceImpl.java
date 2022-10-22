package com.xh.shardingjdbc.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.shardingjdbc.example.mapper.ProductOrderMapper;
import com.xh.shardingjdbc.example.model.ProductOrderEntity;
import com.xh.shardingjdbc.example.service.ProductOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author H.Yang
 * @since 2022-10-10
 */
@Service
public class ProductOrderServiceImpl extends ServiceImpl<ProductOrderMapper, ProductOrderEntity> implements ProductOrderService {

    @Override
    public List<Map<String, Object>> listAll() {
        return super.baseMapper.listAll();
    }
}

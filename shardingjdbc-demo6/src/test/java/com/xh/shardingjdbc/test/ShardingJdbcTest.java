package com.xh.shardingjdbc.test;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.shardingjdbc.example.model.ProductOrderEntity;
import com.xh.shardingjdbc.example.service.ProductOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author H.Yang
 * @date 2022/9/28
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcTest {


    @Autowired
    private ProductOrderService productOrderService;

    /**
     * 分库分表
     */
    @Test
    public void save() {
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            ProductOrderEntity productOrder = new ProductOrderEntity();

            productOrder.setTradeNo(System.currentTimeMillis() + "");
            productOrder.setState("new");
            productOrder.setPayAmount(new BigDecimal(23));
            productOrder.setCreateAt(new Date());
//            productOrder.setUserId(Convert.toLong(i));
            productOrder.setUserId(Convert.toLong(random.nextInt(50)));

            productOrderService.save(productOrder);
        }
    }


    /**
     * 复合分片算法
     */
    @Test
    public void complex() {
        QueryWrapper<ProductOrderEntity> queryWrapper = new QueryWrapper();

//        queryWrapper.lambda().eq(ProductOrderEntity::getId, 1583637680040235011L);
//        queryWrapper.lambda().eq(ProductOrderEntity::getUserId, 46);
        queryWrapper.eq("id", 1583637680040235011L);
        queryWrapper.eq("user_id", 46L);

        productOrderService.list(queryWrapper);
    }

}

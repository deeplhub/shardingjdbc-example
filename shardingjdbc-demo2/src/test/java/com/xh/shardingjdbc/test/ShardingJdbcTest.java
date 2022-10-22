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
     * 分表
     */
    @Test
    public void save() {
        for (int i = 1; i < 10; i++) {
            ProductOrderEntity productOrder = new ProductOrderEntity();

            productOrder.setTradeNo(System.currentTimeMillis() + "");
            productOrder.setState("new");
            productOrder.setPayAmount(new BigDecimal(23));
            productOrder.setCreateAt(new Date());
            productOrder.setUserId(Convert.toLong(i));

            productOrderService.save(productOrder);
        }
    }

}

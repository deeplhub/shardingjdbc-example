package com.xh.shardingjdbc.test;

import cn.hutool.core.convert.Convert;
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
     * 绑定表
     */
    @Test
    public void listAll() {
        List<Map<String, Object>> list = productOrderService.listAll();
        System.out.println();
    }

}

package com.xh.shardingjdbc.test;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.shardingjdbc.example.model.ProductOrderEntity;
import com.xh.shardingjdbc.example.model.SysConfigEntity;
import com.xh.shardingjdbc.example.service.ProductOrderService;
import com.xh.shardingjdbc.example.service.SysConfigService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
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
    private SysConfigService sysConfigService;

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
     * 广播表
     */
    @Test
    public void sysConfigTest() {
        SysConfigEntity config = new SysConfigEntity();

        config.setKey("name");
        config.setValue("andrew");
        config.setType("ad");

        sysConfigService.save(config);

    }


    /**
     * 有分片键
     * <p>
     * hash取模时直接得到对应的表
     */
    @Test
    public void partitionKeyList() {
        QueryWrapper<ProductOrderEntity> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda().eq(ProductOrderEntity::getId, 1583637680040235009L);

        productOrderService.list(queryWrapper);
    }


    /**
     * 无分片键
     * <p>
     * 直接全路由，扫描所有库和所有表，影响性能
     */
    @Test
    public void notPartitionKeyList() {
        QueryWrapper<ProductOrderEntity> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda().eq(ProductOrderEntity::getTradeNo, "1666403620146");

        productOrderService.list(queryWrapper);
    }

}

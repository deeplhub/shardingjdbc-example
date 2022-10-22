package com.xh.shardingjdbc.test;

import cn.hutool.core.convert.Convert;
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
    private SysConfigService sysConfigService;

    @Autowired
    private ProductOrderService productOrderService;

    @Test
    public void listAll() {
        List<Map<String, Object>> list = productOrderService.listAll();
        System.out.println();
    }

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

    @Test
    public void sysConfigTest() {
        SysConfigEntity config = new SysConfigEntity();

        config.setKey("name");
        config.setValue("andrew");
        config.setType("ad");

        sysConfigService.save(config);

    }

}

package com.xh.shardingjdbc.test;

import com.xh.shardingjdbc.example.model.SysConfigEntity;
import com.xh.shardingjdbc.example.service.SysConfigService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void sysConfigTest() {
        SysConfigEntity config = new SysConfigEntity();

        config.setKey("name");
        config.setValue("andrew");
        config.setType("ad");

        sysConfigService.save(config);

    }

}

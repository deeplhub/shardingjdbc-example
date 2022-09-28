package com.xh.shardingjdbc.test;

import com.xh.shardingjdbc.example.model.StudentEntity;
import com.xh.shardingjdbc.example.service.StudentService;
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
    private StudentService studentService;

    @Test
    public void shardingDemo() {
        for (int i = 1; i < 10; i++) {
            StudentEntity student = new StudentEntity();

            student.setUserId(i);
            student.setName("Andrew_" + i);
            student.setAge(i);
            student.setSex(false);

            studentService.save(student);
        }
    }

}

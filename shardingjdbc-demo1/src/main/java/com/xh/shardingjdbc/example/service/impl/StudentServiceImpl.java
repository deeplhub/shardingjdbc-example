package com.xh.shardingjdbc.example.service.impl;

import com.xh.shardingjdbc.example.model.StudentEntity;
import com.xh.shardingjdbc.example.mapper.StudentMapper;
import com.xh.shardingjdbc.example.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author H.Yang
 * @since 2022-09-21
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentEntity> implements StudentService {

}

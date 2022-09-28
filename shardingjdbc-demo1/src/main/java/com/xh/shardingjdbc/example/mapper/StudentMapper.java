package com.xh.shardingjdbc.example.mapper;

import com.xh.shardingjdbc.example.model.StudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author H.Yang
 * @since 2022-09-21
 */
@Mapper
public interface StudentMapper extends BaseMapper<StudentEntity> {

}

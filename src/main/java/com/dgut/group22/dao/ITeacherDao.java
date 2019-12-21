package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ITeacherDao {
    @Select("select * from teacher where teacher_id=#{teacher_id}")
    Teacher findById(String teacher_id);
}

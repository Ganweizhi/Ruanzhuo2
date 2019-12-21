package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ITeacherDao {
    @Select("select * from teacher where teacher_id=#{teacher_id}")
    Teacher findById(String teacher_id);

    @Select("select * from teacher where teacher_id in (select teacher_id from young)")
    List<Teacher> findAllYoungTeacher();
}

package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Academy;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.javaBean.Young;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
//Ning
@Repository
@Mapper
public interface ITeacherDao {
    //按Id查询教师
    @Select("select * from teacher where teacher_id=#{teacher_id}")
    Teacher findById(String teacher_id);

    //查询所有青年教师
    @Select("select * from teacher where teacher_id in (select teacher_id from young)")
    List<Teacher> findAllYoungTeacher();

    //按teacherId查询青年教师
    @Select("select * from young where teacher_id=#{teacher_id}")
    Young findYoungById(String teacher_id);

    @Select("update teacher set teacher_name=#{teacher_name},academy_id=#{academy_id},teacher_birth=#{teacher_birth},teacher_sex=#{teacher_sex},teacher_rank=#{teacher_rank},teacher_phone=#{teacher_phone},teacher_email=#{teacher_email},teacher_qualification=#{teacher_qualification},teacher_domain=#{teacher_domain},teacher_job=#{teacher_job},teacher_address=#{teacher_address},teacher_resdire=#{teacher_resdire},teacher_resume=#{teacher_resume},teacher_photo=#{teacher_photo} where teacher_id=#{teacher_id}")
    void update(Teacher teacher);
}
package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Academy;
import com.dgut.group22.javaBean.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
//Ning

@Repository
@Mapper
public interface IFuZeRenDao {
    //查询所有课程负责人
    @Select("select t.*,c.course_name,c.course_id from teacher t right join course c on t.teacher_id= c.course_principal")
    List<Teacher> findAllFuZeRen();

    //按teacherId查询课程负责人
    @Select("select * from teacher where teacher_id = #{teacher_id}")
    @Results({
            @Result(property = "teacher_id",column = "teacher_id"),
            @Result(property = "teacher_name",column = "teacher_name"),
            @Result(property = "academy_id",column = "academy_id"),
            @Result(property = "academy",column = "academy_id",javaType = Academy.class,one = @One(select = "com.dgut.group22.dao.IAcademyDao.findById")),
            @Result(property = "teacher_birth",column = "teacher_birth"),
            @Result(property = "teacher_sex",column = "teacher_sex"),
            @Result(property = "teacher_rank",column = "teacher_rank"),
            @Result(property = "teacher_phone",column = "teacher_phone"),
            @Result(property = "teacher_email",column = "teacher_email"),
            @Result(property = "teacher_qualification",column = "teacher_qualification"),
            @Result(property = "teacher_domain",column = "teacher_domain"),
            @Result(property = "teacher_job",column = "teacher_job"),
            @Result(property = "teacher_address",column = "teacher_address"),
            @Result(property = "teacher_resdire",column = "teacher_resdire"),
            @Result(property = "teacher_resume",column = "teacher_resume"),
            @Result(property = "teacher_photo",column = "teacher_photo"),
            @Result(property = "course_name",column = "course_name"),
            @Result(property = "course_id",column = "course_id"),
    })
    Teacher findFuZeRenById(String teacher_id);

    @Update("update teacher set teacher_name=#{teacher_name}, academy_id=#{academy_id}, teacher_birth=#{teacher_birth}, teacher_sex=#{teacher_sex}, teacher_rank=#{teacher_rank}, teacher_phone=#{teacher_phone}, teacher_email=#{teacher_email}, teacher_qualification=#{teacher_qualification}, teacher_domain=#{teacher_domain}, teacher_address=#{teacher_address}, teacher_resdire=#{teacher_resdire}, teacher_resume=#{teacher_resume}, teacher_photo=#{teacher_photo}, course_name=#{course_name}, course_id=#{course_id} where teacher_id=#{teacher_id}")
    void update(String teacher_id);
}

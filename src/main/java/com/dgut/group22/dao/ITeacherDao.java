package com.dgut.group22.dao;

import com.dgut.group22.javaBean.*;
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
            @Result(property = "course",column = "course_id",javaType = Course.class,one=@One(select = "com.dgut.group22.dao.ICourseDao.findById")),
            @Result(property = "young",column = "teacher_id",javaType = Young.class,one = @One(select = "com.dgut.group22.dao.ITeacherDao.findYoungById"))
    })
    List<Teacher> findAllYoungTeacher();

    //按teacherId查询青年教师
    @Select("select * from young where teacher_id=#{teacher_id}")
    Young findYoungById(String teacher_id);

    @Select("update teacher set teacher_name=#{teacher_name},academy_id=#{academy_id},teacher_birth=#{teacher_birth},teacher_sex=#{teacher_sex},teacher_rank=#{teacher_rank},teacher_phone=#{teacher_phone},teacher_email=#{teacher_email},teacher_qualification=#{teacher_qualification},teacher_domain=#{teacher_domain},teacher_job=#{teacher_job},teacher_address=#{teacher_address},teacher_resdire=#{teacher_resdire},teacher_resume=#{teacher_resume},teacher_photo=#{teacher_photo} where teacher_id=#{teacher_id}")
    void update(Teacher teacher);

    @Select("delete from young where teacher_id=#{teacher_id}")
    void deleteTeacher(String teacher_id);
}
package com.dgut.group33.dao;

import com.dgut.group22.javaBean.Course;
import com.dgut.group33.javaBean.SuccessCourse;
import com.dgut.group22.javaBean.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SuccessCourseMapper {
    @Select("select * from successCourse")
    @Results({
            @Result(id = true,property = "success_id",column = "success_id"),
            @Result(property = "course_id",column = "course_id"),
            @Result(property = "course",column = "course_id",javaType = Course.class,one=@One(select = "com.dgut.group33.dao.CourseMapper.findById")),
            @Result(property = "teacher_id",column = "teacher_id"),
            @Result(property = "teacher",column = "teacher_id",javaType = Teacher.class,one=@One(select = "com.dgut.group33.dao.TeacherMapper.findById")),
            @Result(property = "time",column = "time"),
            @Result(property = "success_myself",column = "success_myself"),
            @Result(property = "success_student",column = "success_student"),
            @Result(property = "success_society",column = "success_society"),
            @Result(property = "success_evaluation",column = "success_evaluation"),
            @Result(property = "success_wechat",column = "success_wechat"),
            @Result(property = "success_QQ",column = "success_QQ"),
            @Result(property = "success_port",column = "success_port"),
    })
    List<SuccessCourse> findAllSuccessCourse();
    @Insert("insert into successCourse (course_id, teacher_id, time, success_myself, success_student, success_society, success_evaluation, success_wechat, success_QQ, success_port) VALUES (#{course_id}, #{teacher_id}, #{time}, #{success_myself}, #{success_student}, #{success_society}, #{success_evaluation}, #{success_wechat}, #{success_QQ}, #{success_port})")
    int insertSuccessCourse(SuccessCourse successCourse);
}

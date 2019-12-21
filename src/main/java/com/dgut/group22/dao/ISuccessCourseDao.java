package com.dgut.group22.dao;

import com.dgut.group11.javabean.SuccessCourse;
import com.dgut.group22.javaBean.Course;
import com.dgut.group22.javaBean.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
//Ning
@Repository
@Mapper
public interface ISuccessCourseDao {
//    @Select("select * from successCourse")
//    @Results({
//            @Result(id = true,property = "success_id",column = "success_id"),
//            @Result(property = "course_id",column = "course_id"),
//            @Result(property = "course",column = "course_id",javaType = Course.class,one=@One(select = "com.dgut.group22.dao.ICourseDao.findById")),
//            @Result(property = "teacher_id",column = "teacher_id"),
//            @Result(property = "teacher",column = "teacher_id",javaType = Teacher.class,one=@One(select = "com.dgut.group22.dao.ITeacherDao.findById"),
//            @Result(property = "",column = ""),
//            @Result(property = "",column = ""),
//            @Result(property = "",column = ""),
//            @Result(property = "",column = ""),
//            @Result(property = "",column = ""),
//            @Result(property = "",column = ""),
//            @Result(property = "",column = ""),
//            @Result(property = "",column = ""),
//            @Result(property = "",column = ""),
//    })
//    List<SuccessCourse> findAllSuccessCourse();
}

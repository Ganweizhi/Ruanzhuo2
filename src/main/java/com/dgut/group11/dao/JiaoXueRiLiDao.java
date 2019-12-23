package com.dgut.group11.dao;

import com.dgut.group11.javabean.Course;
import com.dgut.group11.javabean.RiLi;
import com.dgut.group11.javabean.SuccessCourse;
import com.dgut.group11.javabean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
lgc
 */
@Repository
@Mapper
public interface JiaoXueRiLiDao {

    @Select("select * from successCourse")
    List<SuccessCourse> findAllSuccessCourse();

    @Select("select * from successCourse where success_id=#{success_id}")
    SuccessCourse findSuccessCourseById(@Param("success_id") int success_id);

    @Select("select * from calendar")
    List<RiLi> findAllRiLiBySuccessCourseId(@Param("success_id") int success_id);

    @Select("select * from teacher where teacher_id=#{teacher_id}")
    Teacher getTeacherById(int teacher_id);

    @Select("select * from course where course_id=#{course_id}")
    Course getCourseById(int course_id);

}

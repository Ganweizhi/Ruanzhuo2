package com.dgut.CCC_WYM.mapper;

import com.dgut.CCC_WYM.beans.course;
import com.dgut.CCC_WYM.beans.successCourse;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface upload {
    @Select("select * from successCourse")
    List<successCourse> getAllSuccessCourse();
    @Select("select * from successCourse where isnull(success_QQ) ")
    List<successCourse> getAllSuccessCourseNotUploadQQ();
    @Select("select course_id from successCourse")
    List<String> getCourse_id();
    @Select("select successCourse.course_id,course_name from successCourse,course where successCourse.course_id = course.course_id")
    List<course> getCourse();
}

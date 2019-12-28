package com.dgut.group22.dao;

import com.dgut.group22.javaBean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface resourceDao {
    @Select("select * from resource")
    List<resource> selectAllResource();

    @Select("select * from experiment_house")
    List<experiment_house> selectAllExperiment_house();

    @Select("select * from course where course_name= #{course_name}")
    Course selectCourseByName(String course_name);

    @Select("select * from teacher where teacher_name= #{teacher_name}")
    Teacher selectTeacherByName(String teacher_name);

    @Select("select * from successCourse where course_id= #{course_id} and teacher_id= #{teacher_id}")
    SuccessCourse selectSuccessCourse(Integer course_id,Integer teacher_id);

    @Insert("insert into resource values (#{resource_id},#{success_id},#{resource_textbook},#{resource_video},#{resource_base},#{resource_experiment},#{resource_document})")
    int insertTextbook(resource resource);

    @Select("select * from successCourse where success_id= #{success_id}")
    SuccessCourse selectSuccessCourseById(Integer success_id);
}

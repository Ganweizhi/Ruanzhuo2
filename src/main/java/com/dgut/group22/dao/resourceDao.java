package com.dgut.group22.dao;

import com.dgut.group22.javaBean.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface resourceDao {
    @Select("select * from resource")
    List<resource> selectAllResource();

    @Select("select * from resource where resource_id=#{resource_id}")
    resource selectResourceById(Integer resource_id);

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

    @Select("select * from course where course_id= #{course_id}")
    Course selectCourseById(int course_id);

    @Select("select * from teacher where teacher_id= #{teacher_id}")
    Teacher selectTeacherById(int teacher_id);

    @Update("update resource set resource_textbook=#{resource_textbook}, resource_video=#{resource_video},  resource_base=#{resource_base}, resource_experiment=#{resource_experiment}, resource_document=#{resource_document} where resource_id= #{resource_id}")
     int DeleteTextbook(resource resource);

    @Delete("delete from experiment_house where experiment_id= #{experiment_id}")
    int DeleteExperiment_house(Integer experiment_id);
}

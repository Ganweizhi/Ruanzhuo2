package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
//Ning
@Repository
@Mapper
public interface ICourseDao {
    //按Id查询
    @Select("select * from course where course_id=#{course_id}")
    Course findById(String course_id);

    @Update("update course set course_name=#{course_name}, course_introduction=#{course_introduction}, course_feature=#{course_feature}, course_material=#{course_material}, course_history=#{course_history}, course_principal=#{course_principal}, course_credit=#{course_credit}, course_period=#{course_period} where course_id=#{course_id}")
    void updateCourse(Course course);
}

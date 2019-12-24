package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
//Ning
@Repository
@Mapper
public interface ICourseDao {
    //按Id查询
    @Select("select * from course where course_id=#{course_id}")
    Course findById(String course_id);
}

package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseMapper {
    @Select("select * from course2 where course_plan_id=#{course_plan_id}")
    List<Course> findCourseByCpid(int course_plan_id);
}

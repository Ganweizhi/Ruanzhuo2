package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Course;
import com.dgut.group33.javaBean.SelectCourse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseMapper {
    @Select("select * from course2 where course_plan_id=#{course_plan_id}")
    List<Course> findCourseByCpid(int course_plan_id);

    @Insert("INSERT INTO course2 (course_period, course_name, course_credit, course_type, course_method, course_time, course_plan_id,course_id) VALUES (#{course_period}, #{course_name}, #{course_credit}, #{course_type}, #{course_method}, #{course_time}, #{course_plan_id},#{course_id})")
    int addCourse(Course course);

    @Select("select * from selectcourse where student_id =#{student_id}")
    SelectCourse findScoreById(int student_id);
    @Insert("insert into  selectcourse (select_id,score,student_id)values(#{select_id},#{score},#{student_id})")
    int  addSelectScore(SelectCourse selectCourse);
}

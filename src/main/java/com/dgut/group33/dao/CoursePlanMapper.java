package com.dgut.group33.dao;

import com.dgut.group33.javaBean.CoursePlan;
import com.dgut.group33.javaBean.Speciality;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CoursePlanMapper {
    @Select("select * from course_plan")
    @Results({
            @Result(id = true,property = "course_plan_id",column = "course_plan_id"),
            @Result(property = "speciality_id",column = "speciality_id"),
            @Result(property = "speciality",column = "speciality_id",javaType = Speciality.class,one=@One(select = "com.dgut.group33.dao.SpecialityMapper.findSpecialityBySid")),
            @Result(property = "grade",column = "grade"),
    })
    List<CoursePlan> findAllCoursePlan();
    @Select("select * from course_plan where course_plan_id=#{course_plan_id}")
    @Results({
            @Result(id = true,property = "course_plan_id",column = "course_plan_id"),
            @Result(property = "speciality_id",column = "speciality_id"),
            @Result(property = "speciality",column = "speciality_id",javaType = Speciality.class,one=@One(select = "com.dgut.group33.dao.SpecialityMapper.findSpecialityBySid")),
            @Result(property = "grade",column = "grade"),
    })
    CoursePlan findCoursePlanById(int course_plan_id);
}

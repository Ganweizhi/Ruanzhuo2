package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Course;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.javaBean.Team;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//Ning
@Repository
@Mapper
public interface ITeamDao {
    @Select("select * from team")
    @Results({
            @Result(property = "team_id",column = "team_id"),
            @Result(property = "team_name",column = "team_name"),
            @Result(property = "course_id",column = "course_id"),
            @Result(property = "course",column = "course_id",javaType = Course.class,one=@One(select = "com.dgut.group22.dao.ICourseDao.findById")),
            @Result(property = "photo_team",column = "photo_team"),
    })
    List<Team> findAllTeam();

    @Select("select * from teacher where teacher_id in (select teacher_id from tbelongt where team_id =#{team_id})")
    List<Teacher> findTeacherByTeamId(String team_id);
}

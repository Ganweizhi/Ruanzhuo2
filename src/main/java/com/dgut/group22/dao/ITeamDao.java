package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.javaBean.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//Ning
@Repository
@Mapper
public interface ITeamDao {
    @Select("select * from team")
    List<Team> findAllTeam();

    @Select("select * from teacher where teacher_id in (select teacher_id from tbelongt where team_id =#{team_id})")
    List<Teacher> findTeacherByTeamId(String team_id);
}

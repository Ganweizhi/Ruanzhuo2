package com.dgut.group22.dao;

import com.dgut.group22.javaBean.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//Ning
@Repository
@Mapper
public interface ITeamDao {
    //查询所有教师团队
    @Select("select * from team")
    @Results({
            @Result(property = "team_id",column = "team_id"),
            @Result(property = "team_name",column = "team_name"),
            @Result(property = "course_id",column = "course_id"),
            @Result(property = "course",column = "course_id",javaType = Course.class,one=@One(select = "com.dgut.group22.dao.ICourseDao.findById")),
            @Result(property = "photo_team",column = "photo_team"),
    })
    List<Team> findAllTeam();

    //按teamId查询教师团队
    @Select("select * from teacher where teacher_id in (select teacher_id from tbelongt where team_id =#{team_id})")
    @Results({
            @Result(property = "teacher_id",column = "teacher_id"),
            @Result(property = "teacher_name",column = "teacher_name"),
            @Result(property = "academy_id",column = "academy_id"),
            @Result(property = "academy",column = "academy_id",javaType = Academy.class,one = @One(select = "com.dgut.group22.dao.IAcademyDao.findById")),
            @Result(property = "teacher_birth",column = "teacher_birth"),
            @Result(property = "teacher_sex",column = "teacher_sex"),
            @Result(property = "teacher_rank",column = "teacher_rank"),
            @Result(property = "teacher_phone",column = "teacher_phone"),
            @Result(property = "teacher_email",column = "teacher_email"),
            @Result(property = "teacher_qualification",column = "teacher_qualification"),
            @Result(property = "teacher_domain",column = "teacher_domain"),
            @Result(property = "teacher_job",column = "teacher_job"),
            @Result(property = "teacher_address",column = "teacher_address"),
            @Result(property = "teacher_resdire",column = "teacher_resdire"),
            @Result(property = "teacher_resume",column = "teacher_resume"),
            @Result(property = "teacher_photo",column = "teacher_photo"),
            @Result(property = "course_name",column = "course_name"),
            @Result(property = "course_id",column = "course_id"),
            @Result(property = "course",column = "course_id",javaType = Course.class,one=@One(select = "com.dgut.group22.dao.ICourseDao.findById")),
    })
    List<Teacher> findTeacherByTeamId(String team_id);

    @Delete("delete from tbelongt where teacher_id=#{teacher_id} and team_id=#{team_id}")
    void deleteTeacher(String teacher_id,String team_id);

    @Insert("insert into tbelongt values(null,#{teacher_id},#{team_id})")
    void addTeacher(String teacher_id, String team_id);

    @Select("select * from tbelongt where team_id=#{team_id} and teacher_id=#{teacher_id}")
    TBelongT findTBelongT(String team_id,String teacher_id);

    @Insert("insert into team values(null,#{team_name},#{course_id})")
    void addTeam(Team team);
}

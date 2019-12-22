/**
 * 教学效果
 * @Author wjwwhs
 */
package com.dgut.group33.dao;

import com.dgut.group33.javaBean.ExpertComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeachingEffectMapper {

    @Select("select * from comment")
    List<ExpertComment> selectAllComment();

    @Select("select * from leader_comment")
    List<ExpertComment> selectAllLeaderComment();

    @Select("select * from teacher_comment")
    List<ExpertComment> selectAllTeacherComment();

    @Select("select * from student_comment")
    List<ExpertComment> selectAllStudentComment();

    @Select("select * from social_comment")
    List<ExpertComment> selectAllSocialComment();
}

/**
 * 教学效果
 * @Author wjwwhs
 */
package com.dgut.group33.dao;

import com.dgut.group11.javabean.RiLi;
import com.dgut.group33.javaBean.ExpertComment;
import org.apache.ibatis.annotations.*;
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

    @Insert(" insert into comment(content,expert) VALUES(#{content},#{expert})")
    void insert1(ExpertComment expertComment);
    @Insert(" insert into leader_comment(content,expert) VALUES(#{content},#{expert})")
    void insert2(ExpertComment expertComment);
    @Insert(" insert into teacher_comment(content,expert) VALUES(#{content},#{expert})")
    void insert3(ExpertComment expertComment);
    @Insert(" insert into student_comment(content,expert) VALUES(#{content},#{expert})")
    void insert4(ExpertComment expertComment);
    @Insert(" insert into social_comment(content,expert) VALUES(#{content},#{expert})")
    void insert5(ExpertComment expertComment);

    @Update("update comment set content=#{content},expert=#{expert} where id=#{id}")
    void edit1(ExpertComment expertComment);
    @Update("update leader_comment set content=#{content},expert=#{expert} where id=#{id}")
    void edit2(ExpertComment expertComment);
    @Update("update teacher_comment set content=#{content},expert=#{expert} where id=#{id}")
    void edit3(ExpertComment expertComment);
    @Update("update student_comment set content=#{content},expert=#{expert} where id=#{id}")
    void edit4(ExpertComment expertComment);
    @Update("update social_comment set content=#{content},expert=#{expert} where id=#{id}")
    void edit5(ExpertComment expertComment);

    @Delete("delete from social_comment where id=#{id}")
    void delete5(int content_id);
    @Delete("delete from student_comment where id=#{id}")
    void delete4(int content_id);
    @Delete("delete from teacher_comment where id=#{id}")
    void delete3(int content_id);
    @Delete("delete from leader_comment where id=#{id}")
    void delete2(int content_id);
    @Delete("delete from comment where id=#{id}")
    void delete1(int content_id);

}

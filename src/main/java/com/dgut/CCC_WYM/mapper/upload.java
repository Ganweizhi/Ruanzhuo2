package com.dgut.CCC_WYM.mapper;

import com.dgut.CCC_WYM.javabeans.*;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Mapper
@Repository
public interface upload {
    @Select("select * from successCourse")
    List<successCourse> getAllSuccessCourse();
    @Select("select * from successCourse where isnull(success_QQ) ")
    List<successCourse> getAllSuccessCourseNotUploadQQ();
    @Select("select course_id from successCourse")
    List<String> getCourse_id();
    @Select("select successCourse.course_id,course_name from successCourse,course where successCourse.course_id = course.course_id")
    List<course> getCourse();
    @Select("select teacher.teacher_id,teacher.teacher_name from teacher,successCourse where teacher.teacher_id= successCourse.teacher_id")
    List<teacher> getSuccessCourseTeacher();
    @Select("select success_id,course.course_name,teacher.teacher_name,time from successCourse,teacher,course where successCourse.teacher_id = teacher.teacher_id and successCourse.course_id = course.course_id and success_QQ is not null")
    List<image_qq> getAllQQImage();
//@Select("select success_id,course.course_name,teacher.teacher_name,time from successCourse,teacher,course where successCourse.teacher_id = teacher.teacher_id and successCourse.course_id = course.course_id ")
//List<image_qq> getAllQQImage();
    @Select("select success_id,course.course_name,teacher.teacher_name,time from successCourse,teacher,course where successCourse.teacher_id = teacher.teacher_id and successCourse.course_id = course.course_id and success_wechat is not null")
    List<image_wechat> getAllWechatImage();
    @Update("update  successCourse set success_QQ = #{qq} where success_id = #{success_id}")
    void setQQimage(@Param("qq")String qq,@Param("success_id")String success_id);
    @Update("update  successCourse set success_wechat = #{wechat} where success_id = #{success_id}")
    void setWechatimage(@Param("wechat")String wechat,@Param("success_id")String success_id);
    @Select("select success_id,course_name from successCourse,course where course.course_id = successCourse.course_id and success_qq is null ")
    List<success_id> getAllSuccess_idForQQ();
    @Select("select success_id,course_name from successCourse,course where course.course_id = successCourse.course_id and success_wechat is null ")
    List<success_id> getAllSuccess_idForWechat();
    @Update("update successCourse set success_QQ=null where success_id = #{success_id}")
    void deleteQQ(String success_id);
    @Update("update successCourse set success_wechat =null where success_id = #{success_id}")
    void deleteWechat(String success_id);
    //前台展示QQ和微信图片
    @Select("select success_QQ,course.course_name,successCourse.course_id from successCourse,course where successCourse.course_id = course.course_id and success_QQ is not null")
    List<beforeQQ> getBeforQQ();
    @Select("select success_wechat,course.course_name,successCourse.course_id from successCourse,course where successCourse.course_id = course.course_id and success_wechat is not null")
    List<beforeWechat> getBeforWechat();

    @Insert("insert into question(name,title,times,content) values(#{name},#{title},#{times},#{content})")
    void insertIntoQuestion(@Param("name")String name,@Param("title")String title,@Param("times")String times,@Param("content")String content);
    @Select("select * from question")
    List<webTitle> getAllTitle();
    @Select("select * from question where question_id = #{question_id}")
    Webquestion getWebQuestionByQid(String qid);
    @Select("select * from question where answer is null")
    List<webTitle> getAllNotslovedQuestion();
    @Update("update question  set answer = #{answer} where question_id = #{question_id}")
    void responesQuestion(@Param("question_id")String question_id,@Param("answer")String answer);

    @Update("update successCourse set success_QQ = #{success_QQ} where success_id = #{success_id}")
    void updateQQ(@Param("success_id")String success_id,@Param("success_QQ")String success_QQ);

    @Update("update successCourse set success_wechat = #{success_wechat} where success_id = #{success_id}")
    void updateWechat(@Param("success_id")String success_id,@Param("success_wechat")String success_wechat);

}

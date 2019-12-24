package com.dgut.group11.gwz.dao;

import com.dgut.group11.gwz.javabean.gwz_Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Gwz_KeChengGaiKuangDao {

    @Select("select * from course")
    public List<gwz_Course> FindAllCourse();

    @Select("select * from course where course_id=#{course_id}")
    public  gwz_Course FindCourseById(int course_id);



    @Insert("insert into course(course_name,course_introduction,course_credit,course_period) values (#{course_name},#{course_introduction},#{course_credit},#{course_period})")
    public void AddJianJie(gwz_Course course);

    @Update("update course set course_name=#{course_name},course_introduction=#{course_introduction},course_credit=#{course_introduction},course_period=#{course_introduction} where course_id=#{course_id}")
    public void EditJianJie(gwz_Course course);



    @Update("update course set course_feature=#{course_feature} where course_id=#{course_id}")
    public void EditTeSe(gwz_Course course);



    @Update("update course set course_material=#{course_material} where course_id=#{course_id}")
    public void EditJiaoCai(gwz_Course course);


    @Update("update course set course_history=#{course_history} where course_id=#{course_id}")
    public void EditLiShi(gwz_Course course);
}

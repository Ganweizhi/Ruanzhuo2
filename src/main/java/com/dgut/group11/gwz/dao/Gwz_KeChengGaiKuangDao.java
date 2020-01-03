package com.dgut.group11.gwz.dao;

import com.dgut.group11.gwz.javabean.gwz_Course;
import com.dgut.group11.gwz.javabean.gwz_academy;
import com.dgut.group11.gwz.javabean.gwz_teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Gwz_KeChengGaiKuangDao {


    @Select("select * from course")
    @Results(id = "FullCourse",value = {
            @Result(id=true,property = "course_id",column = "course_id"),
            @Result(property = "course_name",column = "course_name"),
            @Result(property = "course_introduction",column = "course_introduction"),
            @Result(property = "course_feature",column = "course_feature"),
            @Result(property = "course_material",column = "course_material"),
            @Result(property = "course_history",column = "course_history"),
            @Result(property = "course_principal",column = "course_principal"),
            @Result(property = "course_credit",column = "course_credit"),
            @Result(property = "course_period",column = "course_period"),
            @Result(property = "gwzTeacher",column = "course_principal",
                    one=@One(select = "com.dgut.group11.gwz.dao.Gwz_KeChengGaiKuangDao.FindFullTeacherById"))
    })
    public List<gwz_Course> FindAllFullCourse();




    @Select("select * from teacher where teacher_id=#{teacher_id}")
    @Results(id = "FullTeacher",value = {
            @Result(id=true,property = "teacher_id",column = "teacher_id"),
            @Result(property = "teacher_name",column = "teacher_name"),
            @Result(property = "gwzAcademy",column = "academy_id",
                    many =@Many(select = "com.dgut.group11.gwz.dao.Gwz_KeChengGaiKuangDao.FindBaseAcademyById")
            )
    })
    public gwz_teacher FindFullTeacherById(int teacher_id);



    @Select("select * from academy where academy_id=#{academy_id}")
    @Results(id = "BaseAcademy",value = {
            @Result(id=true,property = "academy_id",column = "academy_id"),
            @Result(property = "academy_name",column = "academy_name"),
    })
    public gwz_academy FindBaseAcademyById(int academy_id);



    @Select("select * from teacher")
    @ResultMap("FullTeacher")
    public List<gwz_teacher> FindFullTeacherList();













    @Select("select * from course where course_id=#{course_id}")
    @ResultMap("FullCourse")
    public  gwz_Course FindCourseById(int course_id);



    @Insert("insert into course(course_name,course_introduction,course_credit,course_period,course_principal) values (#{course_name},#{course_introduction},#{course_credit},#{course_period},#{gwzTeacher.teacher_id})")
    public void AddJianJie(gwz_Course course);

    @Update("update course set course_name=#{course_name},course_introduction=#{course_introduction},course_credit=#{course_credit},course_period=#{course_period},course_principal=#{gwzTeacher.teacher_id} where course_id=#{course_id}")
    public void EditJianJie(gwz_Course course);



    @Update("update course set course_feature=#{course_feature} where course_id=#{course_id}")
    public void EditTeSe(gwz_Course course);



    @Update("update course set course_material=#{course_material} where course_id=#{course_id}")
    public void EditJiaoCai(gwz_Course course);


    @Update("update course set course_history=#{course_history} where course_id=#{course_id}")
    public void EditLiShi(gwz_Course course);

    @Update("update course set course_introduction=null where course_id=#{course_id}")
    public void deleteJianjie(int course_id);


    @Update("update course set course_material=null where course_id=#{course_id}")
    public void deleteJiaoCai(int course_id);

    @Update("update course set course_history=null where course_id=#{course_id}")
    public void deleteLiShi(int course_id);

    @Update("update course set course_feature=null where course_id=#{course_id}")
    public void deleteTeSe(int course_id);


}

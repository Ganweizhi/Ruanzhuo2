package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Course;
import com.dgut.group22.javaBean.Video;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IVideoDao {

    @Select("select c.course_id as course_id ,c.course_name as course_name from course c,successCourse s where c.course_id=s.course_id;")
    public List<Video> FindAllCourseName();

    @Select("SELECT resource_id,course_id from resource r,successCourse s where r.success_id=s.success_id")
    @Results({
            @Result(property = "resource_id",column = "resource_id"),
            @Result(property = "course_id",column = "course_id"),
            @Result(property = "course",column = "course_id",javaType = Course.class,one=@One(select = "com.dgut.group22.dao.ICourseDao.findById"))
    })
    List<Video> findAllVideo();

//    @Select("select resource_video from resource r,(select success_id from successCourse where course_id=#{course_id}) as s where s.success_id=r.success_id;")
//    public String FindCourseVideoPath(String course_id);

    @Select("select resource_video from resource where resource_id=#{arg0};")
    public String FindCourseVideoPath(String course_id);
}

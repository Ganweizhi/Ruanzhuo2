package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IVideoDao {

    @Select("select c.course_id as course_id ,c.course_name as course_name from course c,successCourse s where c.course_id=s.course_id;")
    public List<Video> FindAllCourseName();

    @Select("select resource_video from resource r,(select success_id from successCourse where course_id=#{course_id}) as s where s.success_id=r.success_id;")
    public String FindCourseVideoPath(String course_id);


}

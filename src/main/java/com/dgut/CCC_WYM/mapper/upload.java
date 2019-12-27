package com.dgut.CCC_WYM.mapper;

import com.dgut.CCC_WYM.beans.successCourse;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface upload {
    @Select("select * from successCourse")
    List<successCourse> getAllSuccessCourse();
    @Select("select * from successCourse where isnull(success_QQ) ")
    List<successCourse> getAllSuccessCourseNotUploadQQ();
}

package com.dgut.group11.dao;

import com.dgut.group11.javabean.RiLi;
import com.dgut.group11.javabean.SuccessCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JiaoXueRiLiDao {

    @Select("select * from SuccessCourse")
    List<SuccessCourse> findAllSuccessCourse();

    @Select("select * from SuccessCourse where success_id=#{success_id}")
    SuccessCourse findSuccessCourseById(@Param("success_id") int success_id);

    @Select("select * from calendar")
    List<RiLi> findAllRiLiBySuccessCourseId(@Param("success_id") int success_id);
}

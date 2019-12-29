package com.dgut.group11.dao;


import com.dgut.group11.javabean.Contentb;
import com.dgut.group11.javabean.Problemb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
lgc
 */
@Repository
@Mapper
public interface ProblembDao {


    @Select("select * from problemb where success_id=#{success_id}")
    List<Problemb> findAllProblembBySuccessCourseId(@Param("success_id")int success_id);
}

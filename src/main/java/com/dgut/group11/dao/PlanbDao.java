package com.dgut.group11.dao;

import com.dgut.group11.javabean.Planb;
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
public interface PlanbDao {

    @Select("select * from planb where success_id=#{success_id}")
    List<Planb> findAllPlanbBySuccessCourseId(@Param("success_id") int success_id);
}

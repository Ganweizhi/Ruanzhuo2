package com.dgut.group11.dao;


import com.dgut.group11.javabean.Contentb;
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
public interface ContentBDao {

    @Select("select * from contentb where success_id=#{success_id}")
    List<Contentb> findAllContentbBySuccessCourseId(@Param("success_id") int success_id);
}

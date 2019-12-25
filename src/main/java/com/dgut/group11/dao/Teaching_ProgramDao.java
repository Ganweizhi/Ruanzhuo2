package com.dgut.group11.dao;

import com.dgut.group11.javabean.Teaching_program;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface Teaching_ProgramDao {

    @Select("select * from teaching_program where success_id=#{success_id}")
    public List<Teaching_program> findAllTeaching_programBySuccessCourseId(@Param("success_id") int success_id) ;
}

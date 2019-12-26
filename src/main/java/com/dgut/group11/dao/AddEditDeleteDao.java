package com.dgut.group11.dao;

import com.dgut.group11.javabean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
lgc
 */
@Repository
@Mapper
public interface AddEditDeleteDao {
    @Select("select * from contentb")
    List<Contentb> findAll1();

    @Select("select * from methodb")
    List<Methodb> findAll2();

    @Select("select * from planb")
    List<Planb> findAll3();

    @Select("select * from problemb")
    List<Problemb> findAll4();

    @Select("select * from calendar")
    List<RiLi> findAll5();

    @Select("select * from teaching_program")
    List<Teaching_program> findAll6();
}

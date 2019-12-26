package com.dgut.group11.dao;

import com.dgut.group11.javabean.*;
import org.apache.ibatis.annotations.*;
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

    @Insert(" insert into contentb(contentb_title,contentb_content,success_id) VALUES(#{contentb_title},#{contentb_content},#{success_id})")
    void add1(@Param("contentb")Contentb contentb);
    @Update("update contentb set contentb_title=#{contentb_title},contentb_content=#{contentb_content},success_id=#{success_id} where contentb_id=#{contentb_id}")
    void edit1(@Param("contentb")Contentb contentb);
    @Delete("delete contentb where contentb_id=#{contentb_id}")
    void delete1(@Param("contentb")Contentb contentb);

    @Insert("insert into methodb(methodb_title,methodb_content,success_id) VALUES(#{methodb_title},#{methodb_content},#{success_id})")
    void add2(@Param("methodb")Methodb methodb);
    @Update("update methodb set methodb_title=#{methodb_title},methodb_content=#{methodb_content},success_id=#{success_id} where methodb_id=#{methodb_id}")
    void edit2(@Param("methodb")Methodb methodb);
    @Delete("delete methodb where methodb_id=#{methodb_id}")
    void delete2(@Param("methodb")Methodb methodb);

    @Insert("insert into planb(planb_title,planb_content,success_id) VALUES(#{planb_title},#{planb_content},#{success_id})")
    void add3(@Param("planb")Planb planb);
    @Update("update planb set planb_title=#{planb_title},planb_content=#{planb_content},success_id=#{success_id} where planb_id=#{planb_id}")
    void edit3(@Param("planb")Planb planb);
    @Delete("delete planb where planb_id=#{planb_id}")
    void delete3(@Param("planb")Planb planb);

    @Insert(" insert into problemb(problemb_title,problemb_content,success_id) VALUES(#{problemb_title},#{problemb_content},#{success_id}")
    void add4(@Param("problemb")Problemb problemb);
    @Update("update problemb set problemb_title=#{problemb_title},problemb_content=#{problemb_content},success_id=#{success_id} where problemb_id=#{problemb_id}")
    void edit4(@Param("problemb")Problemb problemb);
    @Delete("delete problemb where problemb_id=#{problemb_id}")
    void delete4(@Param("problemb")Problemb problemb);

}

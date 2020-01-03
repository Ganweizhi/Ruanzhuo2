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
    void add1(Contentb contentb);
    @Update("update contentb set contentb_title=#{contentb_title},contentb_content=#{contentb_content},success_id=#{success_id} where contentb_id=#{contentb_id}")
    void edit1(Contentb contentb);
    @Delete("delete from contentb where contentb_id=#{contentb_id}")
    void delete1(Contentb contentb);

    @Insert("insert into methodb(methodb_title,methodb_content,success_id) VALUES(#{methodb_title},#{methodb_content},#{success_id})")
    void add2(Methodb methodb);
    @Update("update methodb set methodb_title=#{methodb_title},methodb_content=#{methodb_content},success_id=#{success_id} where methodb_id=#{methodb_id}")
    void edit2(Methodb methodb);
    @Delete("delete from methodb where methodb_id=#{methodb_id}")
    void delete2(Methodb methodb);

    @Insert("insert into planb(planb_title,planb_content,success_id) VALUES(#{planb_title},#{planb_content},#{success_id})")
    void add3(Planb planb);
    @Update("update planb set planb_title=#{planb_title},planb_content=#{planb_content},success_id=#{success_id} where planb_id=#{planb_id}")
    void edit3(Planb planb);
    @Delete("delete from planb where planb_id=#{planb_id}")
    void delete3(Planb planb);

    @Insert("insert into problemb(problemb_title,problemb_content,success_id) VALUES(#{problemb_title},#{problemb_content},#{success_id})")
    void add4(Problemb problemb);
    @Update("update problemb set problemb_title=#{problemb_title},problemb_content=#{problemb_content},success_id=#{success_id} where problemb_id=#{problemb_id}")
    void edit4(Problemb problemb);
    @Delete("delete from problemb where problemb_id=#{problemb_id}")
    void delete4(Problemb problemb);

    @Insert("insert into calendar(calendar_title,calendar_content,success_id) VALUES(#{calendar_title},#{calendar_content},#{success_id})")
    void add5(RiLi calendar);
    @Update("update calendar set calendar_title=#{calendar_title},calendar_content=#{calendar_content},success_id=#{success_id} where calendar_id=#{calendar_id}")
    void edit5(RiLi calendar);
    @Delete("delete from calendar where calendar_id=#{calendar_id}")
    void delete5(RiLi calendar);

    @Insert("insert into teaching_program(teaching_program_title,teaching_program_content,success_id) VALUES(#{teaching_program_title},#{teaching_program_content},#{success_id})")
    void add6(Teaching_program teaching_program);
    @Update("update teaching_program set teaching_program_title=#{teaching_program_title},teaching_program_content=#{teaching_program_content},success_id=#{success_id} where teaching_program_id=#{teaching_program_id}")
    void edit6(Teaching_program teaching_program);
    @Delete("delete from teaching_program where teaching_program_id=#{teaching_program_id}")
    void delete6(Teaching_program teaching_program);

    @Select("select success_id,course_id from successCourse")
    List<jiaban> jiabanList();

    @Select("select course_name from Course where course_id=#{course_id}")
    String getCourName(int course_id);
}

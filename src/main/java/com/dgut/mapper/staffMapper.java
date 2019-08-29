package com.dgut.mapper;

import com.dgut.jsonBean.*;
import com.dgut.model.staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface staffMapper {

    @Select("<script>"
            + "select * from staff"
            + " <where>"
            + "  <if test='department != null' > "
            + "     and department = #{department}"
            + " </if>"
            + "  <if test='education != null' > "
            + "     and education = #{education}"
            + " </if>"
            + "  <if test='search != null' > "
            + "     and name = #{search}"
            + " </if>"
            + "</where>"
            + "</script>")
    List<listBean> findList(@Param("department") String department, @Param("education") String education, @Param("search") String search);

    @Select("<script>"
            + "select * from staff"
            + " <where>"
            + "  <if test='department != null' > "
            + "     and department = #{department}"
            + " </if>"
            + "  <if test='education != null' > "
            + "     and education = #{education}"
            + " </if>"
            + "  <if test='search != null' > "
            + "     and name = #{search}"
            + " </if>"
            + "</where>"
            + "</script>")
    List<outlistBean> findOutlist(@Param("department") String department, @Param("education") String education, @Param("search") String search);

    @Update("update staff set departureTime=#{time} where wid=#{wid}")
    void deleteByWid(@Param("wid")String wid,@Param("time")String time);

    @Insert("insert into staff(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,email) VALUES(#{bean.name},#{bean.sex},#{bean.nation},#{bean.nationality},#{bean.origin},#{bean.idType},#{bean.idNumber},#{bean.education},#{bean.degree},#{bean.department},#{bean.job},#{bean.title},#{bean.lPhone},#{bean.sPhone},#{bean.email})")
    int add(@Param("bean") addBean bean);

    @Update("update staff set name=#{msgForm.name},sex=#{msgForm.sex},nation=#{msgForm.nation},nationality=#{msgForm.nationality},origin=#{msgForm.origin},idType=#{msgForm.idType},idNumber=#{msgForm.idNumber},education=#{msgForm.education},degree=#{msgForm.degree},department=#{msgForm.department},job=#{msgForm.job},title=#{msgForm.title},lPhone=#{msgForm.lPhone},sPhone=#{msgForm.sPhone},email=#{msgForm.email} where wid=#{msgForm.wid}")
    int updateMessage(@Param("msgForm")addBean msgForm);

    @Select("<script>"
            + "select wid,name,sex,education,department,baseWage from staff"
            + " <where>"
            + "  <if test='department != null' > "
            + "     and department = #{department}"
            + " </if>"
            + "  <if test='education != null' > "
            + "     and education = #{education}"
            + " </if>"
            + "  <if test='search != null' > "
            + "     and name = #{search}"
            + " </if>"
            + "</where>"
            + "</script>")
    List<wageBean> findXclist(@Param("department")String department, @Param("education")String education, @Param("search")String search);

    @Select("select name from department where department=#{department}")
    String getDepartmentNameByID(@Param("department")String department);

    @Update("update staff set baseWage=#{xcForm.baseWage},bankName=#{xcForm.bankName},bankId=#{xcForm.bankId} where wid=#{xcForm.wid}")
    void Xcedit(@Param("xcForm") addWageBean xcForm);

    @Select("select signingTime from ht where wid=#{wid}")
    List<String> findSigningTimeByWid(@Param("wid")String wid);

    @Insert("insert into staff(name,sex,nation,nationality,origin,idType,idNumber,education,degree,department,job,title,lPhone,sPhone,email,baseWage,bankName,bankId,departureTime) VALUES(#{bean.name},#{bean.sex},#{bean.nation},#{bean.nationality},#{bean.origin},#{bean.idType},#{bean.idNumber},#{bean.education},#{bean.degree},#{bean.department},#{bean.job},#{bean.title},#{bean.lPhone},#{bean.sPhone},#{bean.email},#{bean.baseWage},#{bean.bankName},#{bean.bankId},#{bean.departureTime})")
    void addInList(@Param("bean")outlistBean bean);

    @Select("select count(*) from staff")
    int getNewWid();

    @Select("select department from department where name=#{name}")
    String getDepartmentIDByName(@Param("name")String name);

    @Select("select wid,hid,useTime,signingTime from ht where wid=#{wid}")
    List<emailBean> getHtsByWid(String wid);

    @Select("select departureTime from staff where wid=#{wid}")
    String getDepartureTimeByWid(String wid);

    @Select("select name from  staff where wid=#{wid}")
    String getNameByWid(String wid);

    @Select("select baseWage,time from wages where wid =#{wid}")
    List<baseWages> findBaseWages(@Param("wid") String wid);

    @Select("select department_power from roles where id in (select roles_id from roles_managers where managers_id=#{managers_id});")
    List<String> getDepPower(@Param("managers_id")String managers_id);
}

package com.dgut.mapper;

import com.dgut.model.staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface staffMapper {

    @Select("<script>"
            + "select * from staff"
            + " <where>"
            + "  <if test='department != ''' > "
            + "     and department = #{department}"
            + " </if>"
            + "  <if test='degree != ''' > "
            + "     and degree = #{degree}"
            + " </if>"
            + "  <if test='stime != ''' > "
            + "     and stime = #{stime}"
            + " </if>"
            + "  <if test='etime != ''' > "
            + "     and etime = #{etime}"
            + " </if>"
            + "  <if test='search != ''' > "
            + "     and search = #{search}"
            + " </if>"
            + "</where>"
            + "</script>")
    List<staff> findALL(String department,String degree,String stime,String etime,String search);
}

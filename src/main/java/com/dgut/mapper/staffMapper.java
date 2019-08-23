package com.dgut.mapper;

import com.dgut.jsonBean.listBean;
import com.dgut.model.staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface staffMapper {

    @Select("<script>"
            + "select wid,name,sex,degree,department,lphone,state,signingTime,departureTime from staff"
            + " <where>"
            + "  <if test='department != null' > "
            + "     and department = #{department}"
            + " </if>"
            + "  <if test='degree != null' > "
            + "     and degree = #{degree}"
            + " </if>"
            + "  <if test='search != null' > "
            + "     and name = #{search}"
            + " </if>"
            + "</where>"
            + "</script>")
    List<listBean> findList(@Param("department")String department, @Param("degree")String degree, @Param("stime")String stime, @Param("etime")String etime, @Param("search")String search, @Param("currentPage")String currentPage);

    @Select("select * from staff")
    List<staff> findOutlist(@Param("department")String department, @Param("degree")String degree, @Param("stime")String stime, @Param("etime")String etime, @Param("search")String search);
}

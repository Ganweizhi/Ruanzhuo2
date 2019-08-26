package com.dgut.mapper;

import com.dgut.jsonBean.htlistBean;
import com.dgut.model.UserFileModel;
import org.apache.ibatis.annotations.*;

import javax.net.ssl.SSLContext;
import java.util.List;

@Mapper
public interface UserFileMapper {

//@Select("<script>"
//        + "select file.wid,name,sex,degree,department,fileSize as htSum from file,staff"
//        + " <where>"
//        + "  <if test='department != null' > "
//        + "     and department = #{department}"
//        + " </if>"
//        + "  <if test='education != null' > "
//        + "     and degree = #{degree}"
//        + " </if>"
//        + "  <if test='search != null' > "
//        + "     and name = #{search}"
//        + " </if>"
//        + "</where>"
//        + "</script>")
  @Select("select file.wid,name,sex,degree,department,count(*)as htSum" +
          " from file,staff" +
          "where department=#{department}and degree=#{degree}and name=#{search}" +
          "group by file.wid")
   List<htlistBean> findList(@Param("department")String department,@Param("degree")String degree,@Param("search")String search);
    @Select("select file.wid,name,sex,degree,department,count(*)as htSum" +
            " from file,staff where file.wid = staff.wid" +
            "group by file.wid")
    List<htlistBean> findList1(@Param("department")String department,@Param("degree")String  degree,@Param("search") String search);
    @Delete(
            "delete from file where wid=#{wid} and fileName =#{htName}"
    )
  int deleteHt(@Param("wid")String wid,@Param("htname")String htname);  //当查询到有该合同时再删除该合同

    @Select("select wid,filename from file where wid =#{wid} and fileName = #{htName}")
    UserFileModel findHt(@Param("wid") String wid,@Param("htName") String htName);//先查询，根据返回值判断有无改合同文件

   @Insert("insert into file values(#{wid},#{fileId},#{htName},#{fileName},#{fileSize},#{fileClass}")
   int insertfile(@Param("wid") String wid,@Param("fileId") String fileId,@Param("htName") String fileName,@Param("fileSize") String fileSize,@Param("fileClass") String fileClass);
}

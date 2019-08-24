package com.dgut.mapper;

import com.dgut.jsonBean.htlistBean;
import com.dgut.model.UserFileModel;
import org.apache.ibatis.annotations.*;

import javax.net.ssl.SSLContext;
import java.util.List;

@Mapper
public interface UserFileMapper {


    @Select(
         "<script>"
         +"select file.wid,name,sex,degree,department,count(*)as htSum from staff,file"
            +  "<where>"
            +"<if test='department!=null'>"
            +" and department= #{department}"
            + "</if>"
            +"<if test = 'degree != null'>"
            +"and degree = #{degree}"
            +"</if>"
            +"<if test = 'search !=null'>"
            +" and name = #{search}"
            +"</if>"
            +"</where>"
          +"</script>")
   List<htlistBean> findList(@Param("department")String department,@Param("degree")String degree,@Param("search")String search,@Param("currentPage") String currentPage);
    @Delete(
            "delete from file where wid=#{wid} and fileName =#{htName}"
    )
   public int deleteHt(@Param("wid")String wid,@Param("htname")String htname);  //当查询到有该合同时再删除该合同

    @Select("select wid,filename from file where wid =#{wid} and fileName = #{htName}")
    UserFileModel findHt(@Param("wid") String wid,@Param("htName") String htName);//先查询，根据返回值判断有无改合同文件

   @Insert("insert into file values()")
    public int insertfile(@Param("wid") String wid,String fileId,@Param("htName") String fileName,String fileSize,String fileClass);
}

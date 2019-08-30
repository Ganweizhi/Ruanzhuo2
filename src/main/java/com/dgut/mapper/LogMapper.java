package com.dgut.mapper;

import com.dgut.jsonBean.LogBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface LogMapper {

    @Select("<script>"
            + "select * from log"
            + " <where>"
            + "  <if test='gid != null' > "
            + "     and gid like CONCAT('%',#{gid},'%')"
            + " </if>"
            + "  <if test='name != null' > "
            + "     and name like CONCAT('%',#{name},'%')"
            + " </if>"
            + "  <if test='ip != null' > "
            + "     and ip like CONCAT('%',#{ip},'%')"
            + " </if>"
            + "</where>"
            + "</script>")
    List<LogBean> findList(@Param("gid") String gid, @Param("name") String name, @Param("ip") String ip);

    @Insert("insert into log(date,gid,name,ip,action) VALUES(#{bean.date},#{bean.gid},#{bean.name},#{bean.ip},#{bean.action})")
    int add(@Param("bean") LogBean bean);

}

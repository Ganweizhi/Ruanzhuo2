package com.dgut.mapper;

import com.dgut.jsonBean.emailBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface emailMapper {

    @Select("select wid,hid,useTime,signingTime from ht")
    List<emailBean> getList();

    @Select("select email from staff where wid=#{wid}")
    String getEmailByWid(@Param("wid") String wid);
}

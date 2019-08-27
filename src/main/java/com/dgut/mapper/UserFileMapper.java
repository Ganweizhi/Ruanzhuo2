package com.dgut.mapper;

import com.dgut.jsonBean.htTable;
import com.dgut.jsonBean.htlistBean;
import com.dgut.model.UserFileModel;
import org.apache.ibatis.annotations.*;

import javax.net.ssl.SSLContext;
import java.util.List;

@Mapper
public interface UserFileMapper {
    @Insert("Insert into HT values(#{wid},#{hid},#{hname},#{hurl},#{usetime},#{signingtime})")
    void htInsert(@Param("wid")String wid,@Param("hid") String hid,@Param("hname") String hname, @Param("hurl") String hurl,@Param("usetime") String usetime,@Param("signingtime") String signingtime);

    @Select("select hid,hname,hurl,usetime,signingtime from Ht where wid=#{wid}")
    List<htTable> htSum(@Param("wid") String wid);

    @Update("update staff set sfzz =#{sfzz} where wid =#{wid}")
    void SfzzUpdate(@Param("wid") String wid, @Param("sfzz") String sfzz);

    @Update("update staff set sfzf =#{sfzf} where wid =#{wid}")
    void SfzfUpdate(@Param("wid") String wid, @Param("sfzf") String sfzf);

    @Update("update staff set img =#{img} where wid =#{wid}")
    void ImgUpdate(@Param("wid") String wid,@Param("img") String img);

    @Update("update staff set yhkz =#{yhkz} where wid =#{wid}")
    void YhkzUpdate(@Param("wid") String wid,@Param("yhkz") String yhkz);

    @Update("update staff set yhkf =#{yhkf} where wid =#{wid}")
    void YhkfUpdate(@Param("wid") String wid,@Param("yhkf") String yhkz);

    @Delete("delete from ht where  hid = #{hid}")
    void htDelete(@Param("hid") String hid);

    @Select("select hid,hName,hUrl,useTime,signingTime from HT where hid = #{hid}")
    List<htTable> findHtUrl(@Param("wid") String wid,@Param("hid") String hid);

    @Update("update staff set departureTime =''where wid =#{wid}")
     void updateDtime(@Param("wid") String wid);

    @Select("select hid,Hname,signingTime,useTime,hUrl from ht where wid =#{wid}")
    List<htTable> htTale(@Param("wid") String wid);

    @Select("select departureTime from staff where wid=#{wid}")
    String checkDepartureTime(@Param("wid") String wid);
}

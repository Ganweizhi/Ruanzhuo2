package com.dgut.mapper;

import com.dgut.jsonBean.htlistBean;
import com.dgut.model.UserFileModel;
import org.apache.ibatis.annotations.*;

import javax.net.ssl.SSLContext;
import java.util.List;

@Mapper
public interface UserFileMapper {
    @Insert("insert into HT values(" +
            "#{wid},#{hid},#{hname},#{hurl},#{usetime},#{signingtime}")
    void htInsert(@Param("wid")String wid,@Param("wid") String hid,@Param("hname") String hname, @Param("hurl") String hurl,@Param("usetime") String usetime,@Param("signingtime") String signingtime);

    @Select("select count(*) as htSum from HT where wid =#{wid}")
    int htSum(@Param("wid") String wid);

    @Update("update staff set sfzz =#{sfzz} where wid =#{wid}")
    void SfzzUpdate(@Param("wid") String wid, @Param("sfzz") String sfzz);

    @Update("update staff set sfzf =#{sfzf} where wid =#{wid}")
    void SfzfUpdate(@Param("wid") String wid, @Param("sfzf") String sfzf);

    @Update("update staff set img =#{img} where wid =#{wid}")
    void ImgUpdate(@Param("wid") String wid,@Param("img") String img);
}

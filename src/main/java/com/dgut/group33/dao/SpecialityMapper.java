package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Academy;
import com.dgut.group33.javaBean.Speciality;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SpecialityMapper {
    @Select("select * from speciality where speciality_id=#{speciality_id}")
    @Results({
            @Result(id = true,property = "speciality_id",column = "speciality_id"),
            @Result(property = "speciality_name",column = "speciality_name"),
            @Result(property = "academy_id",column = "academy_id"),
            @Result(property = "academy",column = "academy_id",javaType = Academy.class,one=@One(select = "com.dgut.group33.dao.AcademyMapper.findAcademyByAid")),
    })
    List<Speciality> findSpecialityBySid(int speciality_id);
}

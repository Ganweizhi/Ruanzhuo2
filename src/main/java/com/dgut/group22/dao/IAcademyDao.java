package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Academy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//Ning
@Repository
@Mapper
public interface IAcademyDao {
    @Select("select * from academy where academy_id=#{academy_id}")
    Academy findById(String academy_id);
}

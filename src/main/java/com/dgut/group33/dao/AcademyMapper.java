package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Academy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AcademyMapper {
    @Select("select * from academy where academy_id=#{academy_id}")
    List<Academy> findAcademyByAid(int academy_id);
}

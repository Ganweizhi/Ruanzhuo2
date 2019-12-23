package com.dgut.group22.dao;

import com.dgut.group22.javaBean.experiment_house;
import com.dgut.group22.javaBean.resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface resourceDao {
    @Select("select * from resource")
    List<resource> selectAllResource();

    @Select("select * from experiment_house")
    List<experiment_house> selectAllExperiment_house();


}

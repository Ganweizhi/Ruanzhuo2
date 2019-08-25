package com.dgut.mapper;

import com.dgut.jsonBean.DepartmentBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentMapper {

    @Select("select d.department as value, d.name as label from department d")
    List<DepartmentBean> findAll();
}

package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
//Ning

@Repository
@Mapper
public interface IFuZeRenDao {
    @Select("select *  from teacher where teacher_id in (select course_principal from course)")
    List<Teacher> findAllFuZeRen();
}

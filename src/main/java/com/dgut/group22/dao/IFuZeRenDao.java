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
    @Select("select t.*,c.course_name,c.course_id from teacher t right join course c on t.teacher_id= c.course_principal")
    List<Teacher> findAllFuZeRen();

    @Select("select * from teacher where teacher_id = #{teacher_id}")
    Teacher findFuZeRenById(String teacher_id);
}

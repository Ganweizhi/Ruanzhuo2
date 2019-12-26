package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Academy;
import com.dgut.group22.javaBean.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
//Ning

@Repository
@Mapper
public interface IFuZeRenDao {
    //查询所有课程负责人
    @Select("select t.*,c.course_name,c.course_id from teacher t right join course c on t.teacher_id= c.course_principal")
    @Results({
            @Result(property = "academy",column = "academy_id",javaType = Academy.class,one = @One(select = "com.dgut.group22.dao.IAcademyDao.findById")),
    })
    List<Teacher> findAllFuZeRen();

    //按teacherId查询课程负责人
    @Select("select * from teacher where teacher_id = #{teacher_id}")
    Teacher findFuZeRenById(String teacher_id);
}

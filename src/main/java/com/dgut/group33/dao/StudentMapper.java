package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper {
    @Select("select * from student where class_id=#{class_id}")
    List<Student> findStudentByCid(int class_id);
}

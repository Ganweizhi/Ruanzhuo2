package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper {
    @Select("select * from student where class_id=#{class_id}")
    List<Student> findStudentByCid(int class_id);

    @Insert("insert into student (student_name, student_grade, class_id, student_sex, student_birth, student_natplace, student_email, student_phone)values(#{student_name},#{student_grade}, #{class_id}, #{student_sex}, #{student_birth}, #{student_natplace}, #{student_email}, #{student_phone})")
    int addStudent(Student student);


}

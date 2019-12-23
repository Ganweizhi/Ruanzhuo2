package com.dgut.group33.dao;

import com.dgut.group33.javaBean.HomeWorkCase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HomeCaseMapper {

    @Select("select * from homeworkcase2")
    List<HomeWorkCase> findAllCase();

    @Select("select * from homeworkcase2 where homework_case_id=#{homework_case_id}")
    HomeWorkCase findCaseById(int homework_case_id);

    @Insert("insert into homeworkcase2 (homework_case_id,course_name,homework_content)values(#{homework_case_id},#{course_name},#{homework_content}) ")
    int addHomeCase(HomeWorkCase homeWorkCase);

}

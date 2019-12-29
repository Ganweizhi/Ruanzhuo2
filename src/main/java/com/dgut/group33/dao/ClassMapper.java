package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Class;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClassMapper {
    @Select("select * from class")
    List<Class> findAllClass();
    @Select("select * from class where class_id=#{class_id}")
    Class findClassById(int class_id);
    @Insert("insert into class (class_id,class_name)values(#{class_id},#{class_name})")
    int addClass(Class classinform);
}

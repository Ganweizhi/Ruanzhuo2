package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Young;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IYoungDao {
    @Select("select * from young where teacher_id=#{teacher_id}")
    Young findByTeacherId(String teacher_id);
}

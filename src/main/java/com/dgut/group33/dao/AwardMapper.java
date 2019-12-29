package com.dgut.group33.dao;

import com.dgut.group33.javaBean.AddEditContent;
import com.dgut.group33.javaBean.Measure;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AwardMapper {
    @Select("select * from award order by measure_time desc")
    List<Measure> select();

    @Select("select * from award where content_id=#{content_id}")
    Measure selectA(int content_id);

    @Select("select * from award where measure_id=#{content_id}")
    Measure selectM(int content_id);

    @Delete("delete from award where measure_id=#{measure_id}")
    void delete(int achievement_id);

    @Insert("insert into award (measure_title, measure_time,content_id) values (#{measure_title}, #{measure_time},#{content_id})")
    void insert(AddEditContent measure);

    @Update("update award set measure_title=#{measure_title} where measure_id=#{measure_id}")
    void update(AddEditContent measure);
}

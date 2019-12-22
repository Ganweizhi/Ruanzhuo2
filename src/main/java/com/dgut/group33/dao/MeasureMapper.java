package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Measure;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MeasureMapper {
    @Select("select * from measure")
    List<Measure> select();

    @Select("select * from measure where content_id=#{content_id}")
    Measure selectA(int content_id);

    @Delete("delete from measure where measure_id=#{measure_id}")
    void delete(int achievement_id);

    @Insert("insert into measure (measure_title, measure_time,content_id) values (#{title}, #{time},#{content_id})")
    void insert(Measure measure);

    @Update("update measure set measure_title=#{title},measure_time=#{time},content_id=#{content_id} where achievement_id=#{id}")
    void update(Measure measure);
}

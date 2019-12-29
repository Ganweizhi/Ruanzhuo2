package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Measure;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AchievementMapper {
    @Select("select * from achievement order by measure_time desc")
    List<Measure> select();

    @Select("select * from achievement where content_id=#{content_id}")
    Measure selectA(int content_id);


    @Delete("delete from achievement where achievement_id=#{achievement_id}")
    void delete(int achievement_id);

    @Insert("insert into achievement (achievement_title, achievement_time,content_id) values (#{title}, #{time},#{content_id})")
    void insert(Measure measure);

    @Update("update achievement set achievement_title=#{title},achievement_time=#{time},content_id=#{content_id} where approval_id=#{id}")
    void update(Measure measure);
}

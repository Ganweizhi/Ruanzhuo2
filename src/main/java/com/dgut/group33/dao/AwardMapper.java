package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Measure;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AwardMapper {
    @Select("select * from award")
    List<Measure> select();

    @Select("select * from award where content_id=#{content_id}")
    Measure selectA(int content_id);

    @Delete("delete from award where award_id=#{award_id}")
    void delete(int achievement_id);

    @Insert("insert into award (award_title, award_time,content_id) values (#{title}, #{time},#{content_id})")
    void insert(Measure measure);

    @Update("update award set award_title=#{title},award_time=#{time},content_id=#{content_id} where award_id=#{award_id}")
    void update(Measure measure);
}

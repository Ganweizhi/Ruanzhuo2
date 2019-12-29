package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Measure;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ApprovalMapper {
    @Select("select * from approval order by measure_time desc")
    List<Measure> select();

    @Select("select * from approval where content_id=#{content_id}")
    Measure selectA(int content_id);

    @Delete("delete from approval where achievement_id=#{achievement_id}")
    void delete(int achievement_id);

    @Insert("insert into approval (approval_title, approval_time,content_id) values (#{title}, #{time},#{content_id})")
    void insert(Measure measure);

    @Update("update approval set approval_title=#{title},approval_time=#{time},content_id=#{content_id} where approval_id=#{id}")
    void update(Measure measure);
}

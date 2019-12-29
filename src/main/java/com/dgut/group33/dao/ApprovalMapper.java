package com.dgut.group33.dao;

import com.dgut.group33.javaBean.AddEditContent;
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

    @Select("select * from approval where measure_id=#{content_id}")
    Measure selectM(int content_id);

    @Delete("delete from approval where measure_id=#{measure_id}")
    void delete(int achievement_id);

    @Insert("insert into approval (measure_title, measure_time,content_id) values (#{measure_title}, #{measure_time},#{content_id})")
    void insert(AddEditContent measure);

    @Update("update approval set measure_title=#{measure_title} where measure_id=#{measure_id}")
    void update(AddEditContent measure);
}

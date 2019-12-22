package com.dgut.group33.dao;

import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.javaBean.MeasureContent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ContentMapper {
    @Select("select * from content where content_id=#{content_id}")
    MeasureContent selectA(int content_id);

    @Delete("delete from content where content_id=#{content_id}")
    void delete(int content_id);

    @Insert("insert into content (content_author, content) values (#{author}, #{content})")
    void insert(MeasureContent content);

    @Update("update content set content_author=#{author},content=#{content} where content_id=#{id}")
    void update(MeasureContent content);
}

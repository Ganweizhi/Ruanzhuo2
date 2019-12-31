package com.dgut.group33.dao;

import com.dgut.group33.javaBean.AddEditContent;
import com.dgut.group33.javaBean.Content;
import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.javaBean.MeasureContent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ContentMapper {
    @Select("select * from content where id=#{content_id}")
    MeasureContent selectA(int content_id);

    @Delete("delete from content where id=#{content_id}")
    void delete(int content_id);

    @Insert("insert into content (content_author, content) values (#{content_author}, #{content})")
    void insert(AddEditContent content);

    @Update("update content set content_author=#{content_author},content=#{content} where id=#{content_id}")
    void update(AddEditContent content);

    @Select("select * from content where content_author=#{content_author}")
    MeasureContent selectByAuthor(String content_author);
}

package com.dgut.group22.dao;

import com.dgut.group22.javaBean.Young;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

//Ning
@Repository
@Mapper
public interface IYoungDao {
    @Update("update young set content=#{content} where teacher_id=#{teacher_id}")
    void updateYoung(Young young);

    @Delete("delete from young where teacher_id=#{teacher_id}")
    void deleteYoung(String teacher_id);

    @Select("select * from young where teacher_id=#{teacher_id}")
    Young findYoungById(String teacher_id);

    @Insert("insert into young values(null,#{teacher_id},#{content})")
    void addYoung(Young young);
}

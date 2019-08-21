package com.dgut.mapper;

import com.dgut.model.UserModel;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @ResultMap("BaseResultMap")
    @Select("select * from user")
    List<UserModel> selectAll(UserModel user);
}
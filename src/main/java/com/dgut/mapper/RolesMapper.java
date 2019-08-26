package com.dgut.mapper;

import com.dgut.jsonBean.GllistBean;
import com.dgut.jsonBean.RoleListBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WuJiewei
 *
 */
@Mapper
@Service
public interface RolesMapper {

    /**
     * 查询所有角色
     * @return
     */
    @Select("select id as rid, name, page_power as pagePower, department_power as depPower  from roles")
    List<RoleListBean> findAll();

    /**
     * 根据名称查询角色id
     * @param name
     * @return
     */
    @Select("select id form roles where name = #{name}")
    String findRoleIdsByRoleName(@Param("name")String name);
}

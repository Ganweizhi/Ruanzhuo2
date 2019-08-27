package com.dgut.mapper;

import com.dgut.jsonBean.GllistBean;
import com.dgut.jsonBean.RoleListBean;
import org.apache.ibatis.annotations.Delete;
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
    Integer findRoleIdsByRoleName(@Param("name")String name);

    /**
     * 根据id删除角色
     * @param rid
     */
    @Delete("delete roles where id = #{rid}")
    void deleteRoleById(@Param("rid")Integer rid);

    /**
     * 根据角色id删除roles_managers中的记录
     * @param rid
     */
    @Delete("delete roles_managers where roles_id = #{rid}")
    void deleteRolesManagersById(@Param("rid")Integer rid);
}

package com.dgut.mapper;

import com.dgut.jsonBean.RoleListBean;
import com.dgut.jsonBean.gldelBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WuJiewei
 *
 */
@Mapper
@Service
public interface RolesMapper {
    @Update("update roles set name=#{qxForm.name},page_power=#{qxForm.pagePower},department_power=#{qxForm.depPower} where id=#{qxForm.rid}")
    int qxedit(@Param("qxForm")RoleListBean qxForm);

    @Insert("insert into roles_managers(managers_id,roles_id) VALUES(#{gid},#{rid})")
    int gladd(@Param("rid")String rid, @Param("gid")String gid);

    @Delete("delete roles_managers where roles_id=#{rid} and managers_id=#{gid}")
    int gllists(@Param("rid")String rid, @Param("gid")String gid);

    @Select("select managers_id as gid,managers.name as name from roles_managers,managers where" +
            " roles_id =#{roles_id} and  roles_managers.roles_id =managers.id ")
    List<gldelBean> getGldelBean(@Param("roles_id") String roles_id);

    /**
     * 查询所有角色
     * @return
     */
    @Select("<script>"
            + "select id as rid, name, page_power as pagePower, department_power as depPower from roles"
            + " <where>"
            + "  <if test='rid != null' > "
            + "     and rid like CONCAT('%',#{rid},'%') "
            + " </if>"
            + "  <if test='name != null' > "
            + "     and name like CONCAT('%',#{name},'%') "
            + " </if>"
            + "</where>"
            + "</script>")
//    @Select("select id as rid, name, page_power as pagePower, department_power as depPower from roles")
    List<RoleListBean> findAll(@Param("rid")String rid, @Param("name")String name);

    /**
     * 根据名称查询角色id
     * @param name
     * @return
     */
    @Select("select id from roles where name like #{name}")
    String findRoleIdsByRoleName(@Param("name")String name);

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

    /**
     * 添加一个新的角色
     * @param name
     * @param pagePower
     * @param depPower
     */
    @Insert("insert into roles(name, page_power, department_power) values(#{name}, #{pagePower}, #{depPower})")
    void insertRole(@Param("name")String name, @Param("pagePower")String pagePower, @Param("depPower")String depPower);
}

package com.dgut.mapper;

import com.dgut.jsonBean.GllistBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WuJiewei
 *
 */
@Mapper
@Service
public interface ManagersMapper {

    /**
     * 1. 查询managers的所有字段和roles的name字段
     * @return
     */
    @Select("<script>"
            + "select m.id as gid, m.name, m.state, r.name as role from managers m, roles r, roles_managers mr"
            + " <where>"
            + "  <if test='gid != null' > "
            + "     and m.id like CONCAT('%',#{gid},'%') "
            + " </if>"
            + "  <if test='name != null' > "
            + "     and m.name like CONCAT('%',#{name},'%') "
            + " </if>"
            + " and m.id = mr.managers_id and r.id = mr.roles_id"
            + "</where>"
            + "</script>")
    List<GllistBean> findAll(@Param("gid")String gid, @Param("name")String name);

    /**
     * 2. 根据参数gid更改managers表的state
     * 不需要在业务层判断是否更改了state，应为没修改也会将原本的值传过来
     */
    @Update("update managers set state = #{state} where id = #{gid}")
    void editManagesState(@Param("gid")String gid, @Param("state")String state);

    /**
     * 3. 根据管理员id删除roles_managers中原有的记录
     * 不需要在业务层判断是否更改了角色，应为没修改也会将原本的值传过来
     */
    @Delete("delete roles_managers where managers_id = #{gid}")
    void deleteByManagersId(@Param("gid")String gid);

    /**
     * 4. 在roles_managers表中插入新的角色权限
     * 与函数deleteByManagersId配合使用
     * @param gid
     * @param rid
     */
    @Insert("insert into roles_managers(managers_id, roles_id) values(#{gid}, #{rid})")
    void insertRolesManagers(@Param("gid")String gid, @Param("rid")String rid);

    @Select("select r.page_power from roles r, roles_managers mr where r.id = mr.roles_id and mr.managers_id=#{gid}")
    List<String> findPagePower(@Param("gid")String gid);

    @Insert("insert into managers(id, state) values(#{gid}, #{state})")
    void insertManager(@Param("gid")String gid, @Param("state")String state);

}

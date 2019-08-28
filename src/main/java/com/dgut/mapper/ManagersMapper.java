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
    @Select("select m.id as gid, m.name, m.state, r.name as role from managers m, roles r, roles_managers mr where m.id = mr.managers_id and r.id = mr.roles_id")
    List<GllistBean> findAll();

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

}

package com.dgut.mapper;

import com.dgut.jsonBean.GllistBean;
import com.dgut.model.Managers;
import com.dgut.model.staff;
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
public interface ManagersMapper {
    /**
     * 1. 查询managers的所有字段和roles的name字段
     * @return
     */
    @Select("select m.id as gid, m.name, m.state, r.name as role from managers m, roles r, roles_managers mr where m.id = mr.managers_id and r.id = mr.roles_id")
    List<GllistBean> findAll();
    // 2. 查询一个
    // 3. 按条件查询
    // 4. 插入一个
    // 5. 删除一个
    // 6. 更改一个
}

package com.dgut.mapper;

import com.dgut.jsonBean.GllistBean;
import com.dgut.jsonBean.RoleListBean;
import org.apache.ibatis.annotations.Mapper;
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

    @Select("select id as rid, name, page_power as pagePower, department_power as depPower  from roles")
    List<RoleListBean> findAll();
}

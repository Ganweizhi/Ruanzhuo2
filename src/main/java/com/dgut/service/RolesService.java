package com.dgut.service;

import com.dgut.jsonBean.RoleListBean;
import com.dgut.jsonBean.RoleWithoutIdBean;
import com.dgut.jsonBean.gldelBean;
import com.dgut.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WuJiewei
 *
 */
@Service
public class RolesService {

    @Autowired
    private RolesMapper rolesMapper;

    public List<RoleListBean> findAll(String rid, String name) {
        return rolesMapper.findAll(rid, name);
    }

    public void deleteRoleById(Integer rid) {
        rolesMapper.deleteRoleById(rid);
    }

    public void deleteRolesManagersById(Integer rid) {
        rolesMapper.deleteRolesManagersById(rid);
    }

    public String findRoleIdsByRoleName(String name) {
        return rolesMapper.findRoleIdsByRoleName(name);
    }

    public int qxedit(RoleListBean qxForm) {
        return rolesMapper.qxedit(qxForm);
    }

    public int gladd(String rid, String gid) {
        return rolesMapper.gladd(rid,gid);
    }

    public int gllists(String rid, String gid) {
        return rolesMapper.gllists(rid,gid);
    }

    public List<gldelBean> getGldeBean(String roles_id){
        return rolesMapper.getGldelBean(roles_id);
    }

    public Integer addRole(RoleWithoutIdBean roleWithoutIdBean) {
        try {
            rolesMapper.insertRole(roleWithoutIdBean.getName(), roleWithoutIdBean.getPagePower(), roleWithoutIdBean.getDepPower());
        } catch (Exception e) {
            return 0;
        }

        return 1;
    }
}

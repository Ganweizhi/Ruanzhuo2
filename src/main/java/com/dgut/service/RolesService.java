package com.dgut.service;

import com.dgut.jsonBean.RoleListBean;
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

    public List<RoleListBean> findAll() {
        return rolesMapper.findAll();
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
}

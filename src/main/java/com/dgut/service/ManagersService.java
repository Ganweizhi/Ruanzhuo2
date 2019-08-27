package com.dgut.service;

import com.dgut.jsonBean.GllistBean;
import com.dgut.jsonBean.GllistFromGleditBean;
import com.dgut.mapper.ManagersMapper;
import com.dgut.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WuJiewei
 * 调用mapper层接口
 */
@Service
public class ManagersService {

    @Autowired
    private ManagersMapper managersMapper;

    private RolesMapper rolesMapper;

    @Autowired
    private RolesService rolesService;

    /**
     * 1. 展示所有的管理员
     *
     * @return
     */
    public List<GllistBean> findAll() {
        return managersMapper.findAll();
    }

    /**
     * 2. 修改管理员的状态
     */
    public void editState(String gid, String state) {
        managersMapper.editManagesState(gid, state);
    }

    /**
     * 3. 根据管理员id删除roles_managers表中的所有记录
     *
     * @param gid
     */
    public void deleteByManagersId(String gid) {
        managersMapper.deleteByManagersId(gid);
    }

    /**
     * 4. 将新的管理员的角色插入表中
     *
     * @param gid
     * @param rid
     */
    public void insertRolesManagers(String gid, String rid) {
        managersMapper.insertRolesManagers(gid, rid);
    }

    /**
     * 5.对修改管理员的角色和状态的业务逻辑的实现
     *
     * @param gllistFromGleditBean
     * @return
     */
    public Integer editRolesOfManager(GllistFromGleditBean gllistFromGleditBean) {
        try {
            if (gllistFromGleditBean.getState().equals("true"))
                gllistFromGleditBean.setState("1");
            else
                gllistFromGleditBean.setState("0");
            this.editState(gllistFromGleditBean.getGid(), gllistFromGleditBean.getState());
            this.deleteByManagersId(gllistFromGleditBean.getGid());
            for (String str : gllistFromGleditBean.getRole()) {
                if(!str.equals(",")) {
                    String rid = rolesService.findRoleIdsByRoleName("%" + str + "%");
                    this.insertRolesManagers(gllistFromGleditBean.getGid(), rid);
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}

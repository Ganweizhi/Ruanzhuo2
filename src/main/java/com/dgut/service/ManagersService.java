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
            System.out.println("start_________________");
            this.editState(gllistFromGleditBean.getGid(), gllistFromGleditBean.getState());
            System.out.println("----------editState");
            this.deleteByManagersId(gllistFromGleditBean.getGid());
            System.out.println("-----------deleteByManagersId");
            System.out.println(gllistFromGleditBean);
            for (String str : gllistFromGleditBean.getRole()) {
                System.out.println(str);
                String rid = rolesService.findRoleIdsByRoleName("%" + str + "%");
                System.out.println("--------------findRoleid");
                this.insertRolesManagers(gllistFromGleditBean.getGid(), rid);
                System.out.println("--------------insertRoles");
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}

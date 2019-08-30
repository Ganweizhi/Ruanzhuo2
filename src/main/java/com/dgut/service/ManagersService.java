package com.dgut.service;

import com.dgut.jsonBean.GllistBean;
import com.dgut.jsonBean.GllistFromGleditBean;
import com.dgut.jsonBean.Manager;
import com.dgut.jsonBean.ManagerWithoutNameBean;
import com.dgut.mapper.ManagersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author WuJiewei
 * 调用mapper层接口
 */
@Service
public class ManagersService {

    @Autowired
    private ManagersMapper managersMapper;
    @Autowired
    private HttpSession session;

    @Autowired
    private RolesService rolesService;

    /**
     * 1. 展示所有的管理员
     *
     * @return
     */
    public List<GllistBean> findAll(String gid, String name) {
        return managersMapper.findAll(gid, name);
    }

    public Boolean findPagePower(int index) {
        List<String> list = managersMapper.findPagePower(((Manager) session.getAttribute("manager")).getUsername());
        int res = 0;
        for (String s : list) {
            res = Integer.valueOf(s, 16) | res;
        }
        return (new StringBuffer(Integer.toBinaryString(res)).reverse().toString()).charAt(index) == '0';
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
                if (!str.equals(",")) {
                    String rid = rolesService.findRoleIdsByRoleName("%" + str + "%");
                    this.insertRolesManagers(gllistFromGleditBean.getGid(), rid);
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    public Integer addManager(ManagerWithoutNameBean managerWithoutNameBean) {
        try {
            if (managerWithoutNameBean.getState().equals("true"))
                managerWithoutNameBean.setState("1");
            else
                managerWithoutNameBean.setState("0");
            System.out.println("111111111111111111111111111");
            System.out.println(managerWithoutNameBean);
            managersMapper.insertManager(managerWithoutNameBean.getGid(), managerWithoutNameBean.getState());
            System.out.println("22222222222222222222222222222");
            for (String str : managerWithoutNameBean.getRole()) {
                if (!str.equals(",")) {
                    String rid = rolesService.findRoleIdsByRoleName("%" + str + "%");
                    System.out.println("33333333333333333333333333333333333333");
                    this.insertRolesManagers(managerWithoutNameBean.getGid(), rid);
                    System.out.println("444444444444444444444444444444444444");
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }



}

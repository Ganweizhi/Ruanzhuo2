package com.dgut.service;

import com.dgut.jsonBean.GllistBean;
import com.dgut.mapper.ManagersMapper;
import com.dgut.mapper.RolesMapper;
import com.dgut.model.staff;
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

    /**
     * 1. 展示所有的管理员
     * @return
     */
    public List<GllistBean> findAll() {
        return managersMapper.findAll();
    }

    /**
     * 2. 修改管理员的状态
     */
    public void editState(Integer gid, Integer state) {
        managersMapper.editManagesState(gid, state);
    }

    /**
     * 3. 根据管理员id删除roles_managers表中的所有记录
     * @param gid
     */
    public void deleteByManagersId(Integer gid) {
        managersMapper.deleteByManagersId(gid);
    }

}

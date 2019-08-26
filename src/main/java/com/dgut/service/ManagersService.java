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

    public Integer updateRoles(String state, List<String> rolesNames, String gid) {
        if (state != null){   // 判断是否更改了状态
            managersMapper.editManagesState(gid, state);
        }

        if (!rolesNames.isEmpty()) {  // 判断是否更改了角色

        }
        return 0;
    }

}

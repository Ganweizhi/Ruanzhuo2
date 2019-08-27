package com.dgut.controller;

import com.dgut.jsonBean.GllistChangeBean;
import com.dgut.jsonBean.RoleListBean;
import com.dgut.jsonBean.RoleListBeanPage;
import com.dgut.jsonBean.outlistBean;
import com.dgut.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WuJiewei
 */
@RestController
@CrossOrigin(origins = "*")
public class RoleController {

    @Autowired
    private RolesService rolesService;

    @RequestMapping("/rolelist")
    @ResponseBody
    public RoleListBeanPage findAll() {
        List<RoleListBean> data = rolesService.findAll();
        RoleListBeanPage roleListBeanPage = new RoleListBeanPage(data, data.size());
        return roleListBeanPage;
    }

    @RequestMapping("/roleLists")
    @ResponseBody
    public List<RoleListBean> returnRoleLists() {
        List<RoleListBean> roleListBeans = rolesService.findAll();
        return roleListBeans;
    }


    /**
     * 根据rid删除角色，要注意的是，在删除角色之前，要先删除映射表中相关的记录
     * @param rid
     * @return
     */
    @RequestMapping(value = "/roledelete")
    @ResponseBody
    public Integer deleteRoleById(Integer rid){
        try{
            rolesService.deleteRolesManagersById(rid);
            rolesService.deleteRoleById(rid);
        }catch (Exception e){
            return 0;
        }

        return 1;
    }
}

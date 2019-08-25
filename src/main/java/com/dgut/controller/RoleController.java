package com.dgut.controller;

import com.dgut.jsonBean.RoleListBean;
import com.dgut.jsonBean.RoleListBeanPage;
import com.dgut.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<RoleListBean> roleListBeans = rolesService.findAll();
        RoleListBeanPage roleListBeanPage = new RoleListBeanPage(roleListBeans, roleListBeans.size());
        System.out.println(roleListBeanPage);
        return roleListBeanPage;
    }
}

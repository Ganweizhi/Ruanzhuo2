package com.dgut.controller;

import com.dgut.jsonBean.GllistChangeBean;
import com.dgut.jsonBean.RoleListBean;
import com.dgut.jsonBean.RoleListBeanPage;
import com.dgut.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}

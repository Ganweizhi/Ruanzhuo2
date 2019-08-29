package com.dgut.controller;

import com.dgut.jsonBean.RoleListBean;
import com.dgut.jsonBean.RoleListBeanPage;
import com.dgut.jsonBean.RoleWithoutIdBean;
import com.dgut.jsonBean.gldelBean;
import com.dgut.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     *
     * @param rid
     * @return
     */
    @RequestMapping(value = "/roledelete")
    @ResponseBody
    public Integer deleteRoleById(Integer rid) {
        try {
            rolesService.deleteRolesManagersById(rid);
            rolesService.deleteRoleById(rid);
        } catch (Exception e) {
            return 0;
        }

        return 1;
    }

    /**
     * @author superlgc
     */
    @RequestMapping(value = "/qxedit")
    public String qxedit(@RequestBody RoleListBean qxForm) {
        int state = rolesService.qxedit(qxForm);
        System.out.println("lgc " + qxForm.toString());
        if (state == 1)
            return "{\"success\":1}";
        else
            return "{\"success\":0}";
    }

    @RequestMapping(value = "/gladd")
    public String gladd(String rid, String gid) {
        int state = rolesService.gladd(rid, gid);
        System.out.println(rid);
        System.out.println(gid);
        System.out.println(state);
        if (state == 1)
            return "{\"success\":1}";
        else
            return "{\"success\":0}";
    }

    @RequestMapping(value = "/gldel")
    public String gllists(String rid, String gid) {
        int state = rolesService.gllists(rid, gid);
        System.out.println(rid);
        System.out.println(gid);
        System.out.println(state);
        if (state == 1)
            return "{\"success\":1}";
        else
            return "{\"success\":0}";
    }

    @RequestMapping("/gllists")
    public List<gldelBean> getgledelBean(String rid) {
        return rolesService.getGldeBean(rid);
    }

    @RequestMapping("/roleadd")
    @ResponseBody
    public String addRole(@RequestBody RoleWithoutIdBean roleWithoutIdBean) {
        Integer flag = rolesService.addRole(roleWithoutIdBean);
        if (flag == 1)
            return "{\"success\":1}";
        else
            return "{\"success\":0}";
    }
}

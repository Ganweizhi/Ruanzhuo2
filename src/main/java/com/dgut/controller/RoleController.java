package com.dgut.controller;

import com.dgut.jsonBean.*;
import com.dgut.service.ManagersService;
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
    @Autowired
    private ManagersService managersService;

    @RequestMapping("/rolelist")
    @ResponseBody
    public RoleListBeanPage findAll(String rid, String name, String currentPage) {
        if(managersService.findPagePower(12)) return new RoleListBeanPage(null,-1);
        if(rid.equals("")) {
            rid = null;
        }
        if(name.equals("")) {
            name = null;
        }
        List<RoleListBean> data = rolesService.findAll(rid, name);

        int start = (Integer.parseInt(currentPage)-1)*7;
        int end = start+7>data.size()?data.size():start+7;

        List<RoleListBean> subData = data.subList(start, end);
        RoleListBeanPage roleListBeanPage = new RoleListBeanPage(subData, data.size());
        return roleListBeanPage;
    }

    @RequestMapping("/roleLists")
    @ResponseBody
    public List<RoleListBean> returnRoleLists() {
        List<RoleListBean> roleListBeans = rolesService.findAll(null, null);
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
        if(managersService.findPagePower(14)) return 3;
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
    public String gladd(String rid, String gid,@SessionAttribute Manager manager) {
        if(gid.equals(manager.getUsername()))
            return "{\"success\":3}";
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
        if(managersService.findPagePower(15)) return "{\"success\":3}";
        Integer flag = rolesService.addRole(roleWithoutIdBean);
        if (flag == 1)
            return "{\"success\":1}";
        else
            return "{\"success\":0}";
    }
}

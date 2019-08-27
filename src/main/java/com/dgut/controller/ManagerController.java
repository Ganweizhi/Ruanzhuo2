package com.dgut.controller;

import com.dgut.jsonBean.GllistBean;
import com.dgut.jsonBean.GllistBeanPage;
import com.dgut.jsonBean.GllistChangeBean;
import com.dgut.jsonBean.GllistFromGleditBean;
import com.dgut.service.ManagersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WuJiewei
 * 与管理员相关的控制层
 */

@RestController
@CrossOrigin(origins = "*")
public class ManagerController {

    @Autowired
    private ManagersService managersService;

    /**
     * 封装GllistBeanPage
     * @return
     */
    public Map<Integer, GllistChangeBean> returnMap() {
        GllistChangeBean gllistChangeBean = new GllistChangeBean(0, "hi", new ArrayList<>(), 0);
        GllistChangeBean gllistChangeBean1 = new GllistChangeBean(0, "hi", new ArrayList<>(), 0);
        List<GllistBean> data = managersService.findAll();
        Map<Integer, GllistChangeBean> map = new HashMap<Integer, GllistChangeBean>();  // 合并后的GllistBean保存在map中
        for(GllistBean getById : data) {
            gllistChangeBean = map.get(getById.getGid());  // 通过id判断是否存在对应的管理员
            if(gllistChangeBean != null){  // 存在则合并role字段，并保存到map
//                System.out.println(gllistChangeBean);
                gllistChangeBean.getRole().add(",");
                gllistChangeBean.getRole().add(getById.getRole());
                map.put(getById.getGid(), gllistChangeBean);
            } else {  // 不存在，则将新的保存到map
//                gllistChangeBean = gllistChangeBean1;  这句有拷贝错误，比较隐蔽
                gllistChangeBean = new GllistChangeBean(0, "hi", new ArrayList<>(), 0);  // 只是初始化一哈
                gllistChangeBean.setGid(getById.getGid());
                gllistChangeBean.setName(getById.getName());
                gllistChangeBean.getRole().add(getById.getRole());  // 将GllistBean的Role字段添加到GllistChangeBean的Roles列表
                gllistChangeBean.setState(getById.getState());
                map.put(getById.getGid(), gllistChangeBean);
            }
        }

        return map;
    }


    /**
     * 展示所有的管理员，还要展示对应的角色
     * @return
     */
    @RequestMapping("/gllist")
    @ResponseBody
    public GllistBeanPage findAll() {
        Map<Integer, GllistChangeBean> map = returnMap();
        GllistBeanPage gllistAndNumBean = new GllistBeanPage(map, map.size());
        return gllistAndNumBean;
    }

    /**
     * 修改管理员的角色和状态
     * @param gllistFromGleditBean
     * @return
     */
    @RequestMapping(value = "/gledit",method = RequestMethod.POST)
    @ResponseBody
    public Integer editRolesOfManager(@RequestBody GllistFromGleditBean gllistFromGleditBean) {
//        GllistFromGleditBean gllistFromGleditBean = new GllistFromGleditBean(0, "hi", new ArrayList<>(), 0);
//        gllistFromGleditBean.setGid(request.getParameter("gid"));
        System.out.println(gllistFromGleditBean);
        return managersService.editRolesOfManager(gllistFromGleditBean);
    }
}

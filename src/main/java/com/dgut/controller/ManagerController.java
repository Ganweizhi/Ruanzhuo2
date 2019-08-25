package com.dgut.controller;

import com.dgut.jsonBean.GllistAndNumBean;
import com.dgut.jsonBean.GllistBean;
import com.dgut.service.ManagersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author WuJiewei
 * 与管理员相关的控制层
 */

@RestController
@CrossOrigin(origins = "*")
public class ManagerController {

    @Autowired
    private ManagersService managersService;

    @RequestMapping("/gllist")
    @ResponseBody
    public GllistAndNumBean findAll() {
        GllistBean gllistBean = null;
        List<GllistBean> data = managersService.findAll();
        Map<Integer, GllistBean> map = new HashMap<Integer, GllistBean>();  // 合并后的GllistBean保存在map中
        for(GllistBean getById : data) {
            gllistBean = map.get(getById.getGid());  // 通过id判断是否存在对应的管理员
            if(gllistBean != null){  // 存在则合并role字段，并保存到map
                gllistBean.setRole(gllistBean.getRole() + "," + getById.getRole());
                map.put(gllistBean.getGid(), gllistBean);
            } else {  // 不存在，则将新的保存到map
                map.put(getById.getGid(), getById);
            }
        }

        GllistAndNumBean gllistAndNumBean = new GllistAndNumBean(map, map.size());
        System.out.println(gllistAndNumBean);
        return gllistAndNumBean;
    }
}

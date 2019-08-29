package com.dgut.controller;


import com.dgut.jsonBean.DepartmentBean;
import com.dgut.jsonBean.Manager;
import com.dgut.service.DepartmentService;
import com.dgut.service.GetDepPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private GetDepPower getDepPower;

    @RequestMapping("/department")
    public List<DepartmentBean> getDepartmentList(@SessionAttribute Manager manager){
        List<DepartmentBean> data = departmentService.findAll();
        String depPower = getDepPower.getDepPower(manager.getUsername());
        StringBuilder sb = new StringBuilder(depPower).reverse();
        data = data.stream().filter(bean ->sb.charAt(Integer.parseInt(bean.getValue()))=='1').collect(Collectors.toList());
        return data;
    }
}

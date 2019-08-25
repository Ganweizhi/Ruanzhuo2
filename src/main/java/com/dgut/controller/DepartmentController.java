package com.dgut.controller;


import com.dgut.jsonBean.DepartmentBean;
import com.dgut.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/department")
    public List<DepartmentBean> getDepartmentList(){
        return departmentService.findAll();
    }
}

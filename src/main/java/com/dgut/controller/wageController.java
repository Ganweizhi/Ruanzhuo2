package com.dgut.controller;

import com.dgut.jsonBean.*;
import com.dgut.model.staff;
import com.dgut.service.listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class wageController {

    @Autowired
    private listService listservice;

    @RequestMapping(value = "/xcedit")
    public String Xcedit(@RequestBody addWageBean xcForm ) {
        listservice.Xcedit(xcForm);
        return "{\"success\":1}";
    }

    @RequestMapping(value = "/xclist")
    @ResponseBody
    public wageBeanPage getList(String department, String education, String search ,String currentPage) {
        if(department.equals("")) {
            department = null;
        }
        if(education.equals("")) {
            education = null;
        }
        if(search.equals("")) {
            search = null;
        }

        List<wageBean> data = listservice.findXclist(department, education, search);
        for (wageBean datum : data) {
            datum.setDepartment(listservice.getDepartmentNameByID(datum.getDepartment()));
        }
        int start = (Integer.parseInt(currentPage)-1)*7;
        int end = start+7>data.size()?data.size():start+7;
        List<wageBean> datas = data.subList(start,end);
        wageBeanPage wagetBeanPage = new wageBeanPage(datas,data.size());
        return wagetBeanPage;
    }
}

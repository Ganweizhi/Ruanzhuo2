package com.dgut.controller;
import com.dgut.jsonBean.listBean;
import com.dgut.jsonBean.listBeanPage;
import com.dgut.model.staff;
import com.dgut.service.listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

    @Autowired
    private listService listservice;

//    @RequestMapping(value = "/list")
//    @ResponseBody
//    public listBeanPage getList(String department, String degree, String stime, String etime, String search) {
//        System.out.println(department+"+"+degree+"+"+stime+"+"+etime+"+"+search);
//        List<staff> data = listservice.findAll();
//        System.out.printf(data.toString()+" "+data.size()+"------");
//        return null;
//    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public listBeanPage getList(String department, String degree, String stime, String etime, String search ,String currentPage) {
        if(department.equals("")) {
            department = null;
        }
        if(degree.equals("")) {
            degree = null;
        }
        if(stime.equals("")) {
            stime = null;
        }
        if(etime.equals("")) {
            etime = null;
        }
        if(search.equals("")) {
            search = null;
        }
        if(currentPage.equals("")) {
            currentPage = null;
        }

        System.out.println(department+"+"+degree+"+"+stime+"+"+etime+"+"+search);
        List<listBean> data = listservice.findList(department,degree,stime,etime,search,currentPage);
        listBeanPage listBeanPage = new listBeanPage(data,data.size());
        System.out.println(listBeanPage.toString());
        return listBeanPage;
    }
}

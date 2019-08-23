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
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

    @Autowired
    private listService listservice;

    @RequestMapping(value = "/list")
    @ResponseBody
    public listBeanPage getList(String department, String degree, String stime, String etime, String search ,String currentPage) {
        if(department.equals("")) {
            department = null;
        }
        if(degree.equals("")) {
            degree = null;
        }
        if(search.equals("")) {
            search = null;
        }

        List<listBean> data = listservice.findList(department, degree, stime, etime, search, currentPage);
        if(!stime.equals("")) {
            String[] split = stime.split(",");
            data = data.stream().filter(bean -> bean.getSigningTime().compareTo(split[0]) >= 0 && bean.getSigningTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }

        if(!etime.equals("")) {
            String[] split = etime.split(",");
            data = data.stream().filter(bean -> bean.getDepartureTime().compareTo(split[0]) >= 0 && bean.getDepartureTime().compareTo(split[1]) <= 0).collect(Collectors.toList());
        }

        int start = (Integer.parseInt(currentPage)-1)*7;
        int end = start+7>data.size()?data.size():start+7;
        List<listBean> datas = data.subList(start,end);
        listBeanPage listBeanPage = new listBeanPage(datas,data.size());
        return listBeanPage;
    }
}

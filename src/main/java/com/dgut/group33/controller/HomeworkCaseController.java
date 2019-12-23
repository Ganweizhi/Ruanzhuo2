package com.dgut.group33.controller;
import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.javaBean.Course;
import com.dgut.group33.javaBean.CoursePlan;
import com.dgut.group33.javaBean.HomeWorkCase;
import com.dgut.group33.javaBean.Title;
import com.dgut.group33.service.HomeCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class HomeworkCaseController {

    @Autowired
    HomeCaseService homeCaseService;
    @RequestMapping(value = "/ChungLife_dt_zy/{page}", method = RequestMethod.POST)
    public String getZyal(@PathVariable String page) {
        JSONObject result = new JSONObject();
        List<HomeWorkCase> homeWorkCases = homeCaseService.findAllCase();

        result.put("data", homeWorkCases);
        return result.toJSONString();
    }

    @RequestMapping(value = "/ChungLife_dt_zy_show/{homework_case_id}", method = RequestMethod.POST)
    public String getCoursePlanById(@PathVariable int homework_case_id){
       HomeWorkCase homeWorkCase = homeCaseService.findCaseById(homework_case_id);
        JSONObject result = new JSONObject();
       if(!StringUtils.isEmpty(homeWorkCase)){
           result.put("data", homeWorkCase);
           return result.toJSONString();
       }
        result.put("msg", "查询失败");
        return result.toJSONString();
    }


    @RequestMapping(value = "/ChungLife_dt_zy/addCase", method = RequestMethod.POST)
    public  String addCoursePlan(HomeWorkCase homeWorkCase){
        System.out.println(homeWorkCase);
        int res = homeCaseService.addHomeCase(homeWorkCase);
        JSONObject result = new JSONObject();
        if(res>0){

            result.put("msg", "添加成功");
            return result.toJSONString();
        }else {
            result.put("msg", "添加失败");
            return result.toJSONString();
        }
    }
}

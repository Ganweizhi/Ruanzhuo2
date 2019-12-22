package com.dgut.group33.controller;
import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.javaBean.Class;
import com.dgut.group33.javaBean.Content;
import com.dgut.group33.javaBean.Student;
import com.dgut.group33.javaBean.Title;
import com.dgut.group33.service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class RosterController {
    @Autowired
    RosterService rosterService;
    @RequestMapping(value = "/ChungLife_dt_hmc/{page}", method = RequestMethod.POST)
    public String getHmc(@PathVariable String page) {
        int anInt = Integer.parseInt(page);
        List<Title> titleList = new ArrayList<>();
        List<Class> classes = new ArrayList<>();
        List<Class> allClass = rosterService.findAllClass();
        for (int i = (anInt - 1) * 10; i < (anInt - 1) * 10 + 10 && i < allClass.size(); i++) {
            Title title=new Title();
            classes.add(allClass.get(i));
            title.setTitle(allClass.get(i).getClass_name()+"花名册");
            title.setContent_id(allClass.get(i).getClass_id());
            titleList.add(title);
        }
        JSONObject result = new JSONObject();
        result.put("data", titleList);
        return result.toJSONString();
    }
    @RequestMapping(value = "/ChungLife_dt_hmc/{content_id}", method = RequestMethod.POST)
    public String getHmcById(@PathVariable String content_id) {
        int class_id = Integer.parseInt(content_id);
        List<Student> students = rosterService.findStudentByCid(class_id);
        String title = rosterService.findClassById(class_id).getClass_name();
        JSONObject result = new JSONObject();
        result.put("title", title.concat("花名册"));
        result.put("StudentList", students);
        return result.toJSONString();
    }
}

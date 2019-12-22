package com.dgut.group33.controller;
import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.javaBean.Class;
import com.dgut.group33.javaBean.Title;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class SchoolReportController {
    @RequestMapping(value = "/ChungLife_dt_cjd/{page}", method = RequestMethod.POST)
    public String getCjd(@PathVariable String page) {

        JSONObject result = new JSONObject();
        List<Title> titleList = new ArrayList<Title>();
        result.put("data", titleList);
        return result.toJSONString();
    }

    @RequestMapping(value = "/ChungLife_dt_cjd_show/{content_id}", method = RequestMethod.POST)
    public String getCjdById(@PathVariable String content_id) {
        JSONObject result = new JSONObject();

        result.put("title", 123);
        result.put("date", 123);
        result.put("author", 123);
        result.put("content", 123);
        return result.toJSONString();
    }
}

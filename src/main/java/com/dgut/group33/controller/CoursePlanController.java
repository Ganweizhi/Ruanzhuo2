package com.dgut.group33.controller;
import com.alibaba.fastjson.JSONObject;
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
public class CoursePlanController {
    @RequestMapping(value = "/ChungLife_dt/{page}", method = RequestMethod.POST)
    public String getKkjh(@PathVariable String page) {
        JSONObject result = new JSONObject();
        List<Title> titleList = new ArrayList<Title>();
        result.put("data", titleList);
        return result.toJSONString();
    }
}

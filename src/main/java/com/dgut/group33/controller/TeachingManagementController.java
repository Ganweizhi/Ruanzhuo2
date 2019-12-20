package com.dgut.group33.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeachingManagementController {
    @Autowired

    @ResponseBody
    @RequestMapping("/ChungLife_dt")
    public String getKkjh() {
        JSONObject result = new JSONObject();

        result.put("titleList", 123);
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/ChungLife_dt_sk",method = RequestMethod.POST)
    public String getSkbj() {
        JSONObject result = new JSONObject();

        result.put("titleList", 123);
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/ChungLife_dt_hmc")
    public String getHmc() {
        JSONObject result = new JSONObject();

        result.put("titleList", 123);
        return result.toJSONString();
    }


    @ResponseBody
    @RequestMapping("/ChungLife_dt_cjd")
    public String getCjd() {
        JSONObject result = new JSONObject();

        result.put("titleList", 123);
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/ChungLife_dt_cjd_show",method = RequestMethod.POST)
    public String getCjdById() {
        JSONObject result = new JSONObject();

        result.put("title", 123);
        result.put("date", 123);
        result.put("author", 123);
        result.put("content", 123);
        return result.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/ChungLife_dt_zy")
    public String getZyal() {
        JSONObject result = new JSONObject();

        result.put("titleList", 123);
        return result.toJSONString();
    }
}

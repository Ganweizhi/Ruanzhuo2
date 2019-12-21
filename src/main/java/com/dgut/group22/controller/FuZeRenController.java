package com.dgut.group22.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.service.FuZeRenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Ning
@RestController
@RequestMapping("/FuZeRen")
public class FuZeRenController {
    @Autowired
    FuZeRenService fuZeRenService;

    @RequestMapping(value="/findAllFuZeRen/{page}",method = {RequestMethod.POST})
    public String findAllFuZeRen(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<Teacher> fuZeRen = new ArrayList<>();
        List<Teacher> allFuZeRen = fuZeRenService.findAllFuZeRen();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allFuZeRen.size(); i++){
            fuZeRen.add(allFuZeRen.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allFuZeRen.size()%9==0?0:1;

        jsonObject.put("page",allFuZeRen.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",fuZeRen);
        return jsonObject.toJSONString();
    }

    @RequestMapping("/findFuZeRenById")
    @ResponseBody
    public String  findFuZeRenId(@RequestParam String teacher_id){
        Teacher fuZeRen = fuZeRenService.findFuZeRenById(teacher_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",fuZeRen);
        return jsonObject.toJSONString();
    }

}

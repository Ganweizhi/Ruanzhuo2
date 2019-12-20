package com.dgut.group11.controller;

import com.dgut.group11.javabean.CourseRiLi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class JiaoXueRiLiController {

    @Autowired
    private HttpServletRequest request;




    @RequestMapping(value="/jiao_xue_ri_li/{page}",method = {RequestMethod.POST})
    public String jiao_xue_ri_li(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);//一页10个

        List<CourseRiLi> courseRiLis = new ArrayList<>();

        return "";
    }
}
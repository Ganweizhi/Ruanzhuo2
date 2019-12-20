package com.dgut.group11.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group11.javabean.CourseRiLi;
import com.dgut.group11.javabean.RiLi;
import com.dgut.group11.javabean.SuccessCourse;
import com.dgut.group11.service.JiaoXueRiLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/*
lgc
 */

@RestController
@CrossOrigin(origins = "*")
public class JiaoXueRiLiController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JiaoXueRiLiService jiaoXueRiLiService;




    @RequestMapping(value="/ka_ke_ke_cheng/{page}",method = {RequestMethod.POST})
    public String ka_ke_ke_cheng(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);//一页10个

        List<SuccessCourse> successCourses = new ArrayList<>();
        List<SuccessCourse> allSuccessCourse = jiaoXueRiLiService.findAllSuccessCourse();
        for(int i=(anInt-1)*10; i<(anInt-1)*10+10 && i<allSuccessCourse.size(); i++){
            successCourses.add(allSuccessCourse.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allSuccessCourse.size()%10==0?0:1;
        jsonObject.put("tatolPage",allSuccessCourse.size()/10+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",successCourses);

        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/jiao_xue_ri_li/{success_id}",method = {RequestMethod.POST})
    public String jiao_xue_ri_li(@PathVariable("success_id") String coureseId){
        int success_id = Integer.parseInt(coureseId);

        SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(success_id);
        List<RiLi> riLiList = jiaoXueRiLiService.findAllRiLiBySuccessCourseId(success_id);

        CourseRiLi courseRiLi = new CourseRiLi(successCourse,riLiList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",courseRiLi);

        return jsonObject.toJSONString();
    }



}
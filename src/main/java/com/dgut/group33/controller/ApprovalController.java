package com.dgut.group33.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.dao.ApprovalMapper;
import com.dgut.group33.dao.ContentMapper;
import com.dgut.group33.javaBean.AddEditContent;
import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.javaBean.MeasureContent;
import com.dgut.group33.service.ApprovalService;
import com.dgut.group33.service.ContentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class ApprovalController {
    @Autowired
    private ApprovalService approvalService;
    @Autowired
    private ContentService contentService;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private ApprovalMapper approvalMapper;

    //前台教学立项界面
    @RequestMapping(value = "/lixiang/{page}",method = {RequestMethod.POST})
    public String selectAllApproval(@PathVariable("page") String page) {
        List<Measure> allApproval=approvalService.selectAllApproval();
        int one = Integer.parseInt(page);
        List<Measure> approval = new ArrayList<>();


        for(int i=(one-1)*9; i<(one-1)*9+9 && i<allApproval.size(); i++){
            approval.add(allApproval.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allApproval.size()%9==0?0:1;

        jsonObject.put("page",allApproval.size()/9+r);
        jsonObject.put("curPage",one);
        jsonObject.put("data",approval);
        return jsonObject.toJSONString();
    }


    //前台教学立项界面--文章内容
    @RequestMapping(value="/lixiang-neirong/{content_id}",method = {RequestMethod.POST})
    public String selectA(@PathVariable("content_id") String contentid){
        int content_id = Integer.parseInt(contentid);

        Measure measure=approvalService.selectA(content_id);
        MeasureContent measureContent=contentService.selectA(content_id);
        measure.setMeasureContent(measureContent);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",measure);

        return jsonObject.toJSONString();
    }


    //后台管理教学立项-删除
    @RequestMapping(value="/dele-lixiang/{content_id}",method = {RequestMethod.POST})
    public String deleteA(@PathVariable("content_id") String contentid) {
        int content_id = Integer.parseInt(contentid);
        JSONObject jsonObject = new JSONObject();
        try {
            Measure measure=approvalMapper.selectM(content_id);
            approvalService.delete(content_id);
            contentMapper.delete(measure.getContent_id());
            jsonObject.put("data", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("data", 0);
        }
        return jsonObject.toJSONString();
    }

    //后台管理教学立项-添加
    @RequestMapping(value="/add-lixiang",method = {RequestMethod.POST})
    public String insertA(@RequestBody AddEditContent measure2){
        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        measure2.setMeasure_time(df.format(new Date()));
        try {
            contentMapper.insert(measure2);
            MeasureContent content=contentMapper.selectByAuthor(measure2.getContent_author());
            measure2.setContent_id(content.getId());
            approvalMapper.insert(measure2);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }
        return jsonObject.toJSONString();
    }

    //后台管理教学立项-修改
    @RequestMapping(value="/edit-lixiang",method = {RequestMethod.POST})
    public String alterA(@RequestBody AddEditContent measure2){
        JSONObject jsonObject = new JSONObject();
        try {
            System.out.println(measure2);
            approvalMapper.update(measure2);
            contentMapper.update(measure2);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }

        return jsonObject.toJSONString();
    }

    //后台管理教学立项-展示所有
    @RequestMapping(value="/alllixiang",method = {RequestMethod.GET})
    public String select(@Param("page") int page, @Param("limit") int limit){
        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=approvalService.selectAllApproval();
        for(int i=0;i<measures.size();i++){
            MeasureContent measureContent1=contentService.selectA((measures.get(i)).getContent_id());
            Measure measure2=measures.get(i);
            measure2.setMeasureContent(measureContent1);
            measure1.add(measure2);
        }

        List<Measure> measure3=new ArrayList<>();
        for(int i=(page-1)*limit,j=i; i<j+limit && i< measure1.size(); i++){
            measure3.add(measure1.get(i));
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",measure3.size());
        jsonObject.put("data",measure3);
        return jsonObject.toJSONString();
    }
}

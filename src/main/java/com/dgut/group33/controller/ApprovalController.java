package com.dgut.group33.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.javaBean.MeasureContent;
import com.dgut.group33.service.ApprovalService;
import com.dgut.group33.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class ApprovalController {
    @Autowired
    private ApprovalService approvalService;
    @Autowired
    private ContentService contentService;

    //前台教学立项界面
    @RequestMapping(value = "/xiliang/{page}",method = {RequestMethod.POST})
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


    //后台管理教学立项--删除
    @RequestMapping(value="/dele-lixiang/{content_id}",method = {RequestMethod.POST})
    public String deleteA(@PathVariable("content_id") String contentid){
        int content_id = Integer.parseInt(contentid);

        approvalService.delete(content_id);
        contentService.delete(content_id);

        List<Measure> measure=new ArrayList<>();
        List<Measure> measures=approvalService.selectAllApproval();
        for(int i=0;i<measures.size();i++){
            MeasureContent measureContent=contentService.selectA((measures.get(i)).getContent_id());
            Measure measure1=measures.get(i);
            measure1.setMeasureContent(measureContent);
            measure.add(measure1);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",measure);

        return jsonObject.toJSONString();
    }


    //后台管理教学立项--添加
    @RequestMapping(value="/add-lixiang",method = {RequestMethod.POST})
    public String insertA(@RequestParam Map<String,String> map){

        MeasureContent measureContent=new MeasureContent();
        measureContent.setContent_author(map.get("author"));
        measureContent.setContent(map.get("content"));
        contentService.insert(measureContent);

        Measure measure=new Measure();
        measure.setAchievement_title(map.get("title"));
        measure.setAchievement_time(map.get("date"));
        measure.setMeasureContent(contentService.selectA(Integer.parseInt(map.get("contentid"))));
        approvalService.insert(measure);

        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=approvalService.selectAllApproval();
        for(int i=0;i<measures.size();i++){
            MeasureContent measureContent1=contentService.selectA((measures.get(i)).getContent_id());
            Measure measure2=measures.get(i);
            measure2.setMeasureContent(measureContent1);
            measure1.add(measure2);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",measure1);

        return jsonObject.toJSONString();
    }


    //后台管理教学立项--修改
    @RequestMapping(value="/edit-lixiang",method = {RequestMethod.POST})
    public String alterA(@RequestParam Map<String,String> map){

        MeasureContent measureContent=new MeasureContent();
        measureContent.setContent_author(map.get("author"));
        measureContent.setContent(map.get("content"));
        contentService.update(measureContent);

        Measure measure=new Measure();
        measure.setAchievement_title(map.get("title"));
        measure.setAchievement_time(map.get("date"));
        measure.setMeasureContent(contentService.selectA(Integer.parseInt(map.get("contentid"))));
        approvalService.update(measure);

        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=approvalService.selectAllApproval();
        for(int i=0;i<measures.size();i++){
            MeasureContent measureContent1=contentService.selectA((measures.get(i)).getContent_id());
            Measure measure2=measures.get(i);
            measure2.setMeasureContent(measureContent1);
            measure1.add(measure2);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",measure1);

        return jsonObject.toJSONString();
    }


    //后台管理教学立项--展示所有
    @RequestMapping(value="/allApproval",method = {RequestMethod.POST})
    public String select(){
        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=approvalService.selectAllApproval();
        for(int i=0;i<measures.size();i++){
            MeasureContent measureContent1=contentService.selectA((measures.get(i)).getContent_id());
            Measure measure2=measures.get(i);
            measure2.setMeasureContent(measureContent1);
            measure1.add(measure2);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",measure1);

        return jsonObject.toJSONString();
    }
}

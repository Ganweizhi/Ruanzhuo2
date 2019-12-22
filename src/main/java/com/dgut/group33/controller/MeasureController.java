package com.dgut.group33.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.javaBean.MeasureContent;
import com.dgut.group33.service.ContentService;
import com.dgut.group33.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class MeasureController {
    @Autowired
    private MeasureService measureService;
    @Autowired
    private ContentService contentService;

    //前台教学措施界面
    @RequestMapping(value = "/cuoshi/{page}",method = {RequestMethod.POST})
    public String selectAllMeasure(@PathVariable("page") String page) {

        List<Measure> allMeasure=measureService.selectAllMeasure();
        int anInt = Integer.parseInt(page);
        List<Measure> measure = new ArrayList<>();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allMeasure.size(); i++){
            measure.add(allMeasure.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allMeasure.size()%9==0?0:1;

        jsonObject.put("page",allMeasure.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",measure);
        return jsonObject.toJSONString();
    }

    //前台教学措施界面--文章信息
    @RequestMapping(value="/cuoshi-neirong/{content_id}",method = {RequestMethod.POST})
    public String selectA(@PathVariable("content_id") String contentid){
        int content_id = Integer.parseInt(contentid);

        Measure measure=measureService.selectA(content_id);
        MeasureContent measureContent=contentService.selectA(content_id);
        measure.setMeasureContent(measureContent);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",measure);

        return jsonObject.toJSONString();
    }

    //后台管理教学措施--删除
    @RequestMapping(value="/dele-cuoshi/{content_id}",method = {RequestMethod.POST})
    public String deleteA(@PathVariable("content_id") String contentid){
        int content_id = Integer.parseInt(contentid);

        measureService.delete(content_id);
        contentService.delete(content_id);

        List<Measure> measure=new ArrayList<>();
        List<Measure> measures=measureService.selectAllMeasure();
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

    //后台管理教学措施--添加
    @RequestMapping(value="/add-cuoshi",method = {RequestMethod.POST})
    public String insertA(@RequestParam Map<String,String> map){
        MeasureContent measureContent=new MeasureContent();
        measureContent.setContent_author(map.get("author"));
        measureContent.setContent(map.get("content"));
        contentService.insert(measureContent);

        Measure measure=new Measure();
        measure.setAchievement_title(map.get("title"));
        measure.setAchievement_time(map.get("date"));
        measure.setMeasureContent(contentService.selectA(Integer.parseInt(map.get("contentid"))));
        measureService.insert(measure);

        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=measureService.selectAllMeasure();
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

    //后台管理教学措施--修改
    @RequestMapping(value="/edit-cuoshi",method = {RequestMethod.POST})
    public String alterA(@RequestParam Map<String,String> map){

        MeasureContent measureContent=new MeasureContent();
        measureContent.setContent_author(map.get("author"));
        measureContent.setContent(map.get("content"));
        contentService.update(measureContent);

        Measure measure=new Measure();
        measure.setAchievement_title(map.get("title"));
        measure.setAchievement_time(map.get("date"));
        measure.setMeasureContent(contentService.selectA(Integer.parseInt(map.get("contentid"))));
        measureService.update(measure);

        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=measureService.selectAllMeasure();
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

    //后台管理教学措施--展示所有
    @RequestMapping(value="/allcuoshi",method = {RequestMethod.POST})
    public String select(){
        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=measureService.selectAllMeasure();
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


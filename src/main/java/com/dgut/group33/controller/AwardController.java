package com.dgut.group33.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.javaBean.MeasureContent;
import com.dgut.group33.service.AwardService;
import com.dgut.group33.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/award")
public class AwardController {
    @Autowired
    private AwardService awardService;
    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/selectAll/{page}",method = {RequestMethod.POST})
    public String selectAllAward(@PathVariable("page") String page) {

        int one = Integer.parseInt(page);
        List<Measure> award = new ArrayList<>();
        List<Measure> allAward=awardService.selectAllAward();

        for(int i=(one-1)*9; i<(one-1)*9+9 && i<allAward.size(); i++){
            award.add(allAward.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allAward.size()%9==0?0:1;

        jsonObject.put("page",allAward.size()/9+r);
        jsonObject.put("curPage",one);
        jsonObject.put("data",award);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/selectA/{content_id}",method = {RequestMethod.POST})
    public String selectA(@PathVariable("content_id") String contentid){
        int content_id = Integer.parseInt(contentid);

        Measure measure=awardService.selectA(content_id);
        MeasureContent measureContent=contentService.selectA(content_id);
        measure.setMeasureContent(measureContent);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",measure);

        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/delete/{content_id}",method = {RequestMethod.POST})
    public String deleteA(@PathVariable("content_id") String contentid){
        int content_id = Integer.parseInt(contentid);

        awardService.delete(content_id);
        contentService.delete(content_id);

        List<Measure> measure=new ArrayList<>();
        List<Measure> measures=awardService.selectAllAward();
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

    @RequestMapping(value="/insert",method = {RequestMethod.POST})
    public String insertA(@RequestParam Map<String,String> map){
        /*int content_id = Integer.parseInt(contentid);

        Measure measure=achievementService.selectA(content_id);
        MeasureContent measureContent=contentService.selectA(content_id);
        measure.setMeasureContent(measureContent);*/
        MeasureContent measureContent=new MeasureContent();
        measureContent.setContent_author(map.get("author"));
        measureContent.setContent(map.get("content"));
        contentService.insert(measureContent);

        Measure measure=new Measure();
        measure.setAchievement_title(map.get("title"));
        measure.setAchievement_time(map.get("date"));
        measure.setMeasureContent(contentService.selectA(Integer.parseInt(map.get("contentid"))));
        awardService.insert(measure);

        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=awardService.selectAllAward();
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

    @RequestMapping(value="/alter",method = {RequestMethod.POST})
    public String alterA(@RequestParam Map<String,String> map){
        //int content_id = Integer.parseInt(map.);

        MeasureContent measureContent=new MeasureContent();
        measureContent.setContent_author(map.get("author"));
        measureContent.setContent(map.get("content"));
        contentService.update(measureContent);

        Measure measure=new Measure();
        measure.setAchievement_title(map.get("title"));
        measure.setAchievement_time(map.get("date"));
        measure.setMeasureContent(contentService.selectA(Integer.parseInt(map.get("contentid"))));
        awardService.update(measure);

        //List<Measure> allAchievement=achievementService.selectAllAchievement();
        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=awardService.selectAllAward();
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

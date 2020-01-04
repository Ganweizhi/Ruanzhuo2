package com.dgut.group33.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.dao.ContentMapper;
import com.dgut.group33.dao.MeasureMapper;
import com.dgut.group33.javaBean.AddEditContent;
import com.dgut.group33.javaBean.Content;
import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.javaBean.MeasureContent;
import com.dgut.group33.service.ContentService;
import com.dgut.group33.service.MeasureService;
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
@CrossOrigin(origins = "*")
@ResponseBody
public class MeasureController {
    @Autowired
    private MeasureService measureService;
    @Autowired
    private ContentService contentService;
    @Autowired
    private MeasureMapper measureMapper;
    @Autowired
    private ContentMapper contentMapper;

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
    public String deleteA(@PathVariable("content_id") String contentid) {
        int content_id = Integer.parseInt(contentid);
        JSONObject jsonObject = new JSONObject();
        try {
            Measure measure=measureMapper.selectM(content_id);
            measureService.delete(content_id);
            contentMapper.delete(measure.getContent_id());
            jsonObject.put("data", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("data", 0);
        }
        return jsonObject.toJSONString();
    }

    //后台管理教学措施--添加
    @RequestMapping(value="/add-cuoshi",method = {RequestMethod.POST})
    public String insertA(@RequestBody AddEditContent measure2){
        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        measure2.setMeasure_time(df.format(new Date()));
        try {
            contentMapper.insert(measure2);
            MeasureContent content=contentMapper.selectByAuthor(measure2.getContent_author());
            measure2.setContent_id(content.getId());
            measureMapper.insert(measure2);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }
        return jsonObject.toJSONString();
    }

    //后台管理教学措施--修改
    @RequestMapping(value="/edit-cuoshi",method = {RequestMethod.POST})
    public String alterA(@RequestBody AddEditContent measure2){
        JSONObject jsonObject = new JSONObject();
        try {
            System.out.println(measure2);
            measureMapper.update(measure2);
            contentMapper.update(measure2);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }

        return jsonObject.toJSONString();
    }

    //后台管理教学措施--展示所有
    @RequestMapping(value="/allcuoshi",method = {RequestMethod.GET})
    public String select(@Param("page") int page, @Param("limit") int limit){
        List<Measure> measure1=new ArrayList<>();
        List<Measure> measures=measureService.selectAllMeasure();
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


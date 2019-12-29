/**
 * 教学效果前台控制
 * @Author wjwwhs
 */
package com.dgut.group33.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group33.javaBean.ExpertComment;
import com.dgut.group33.service.TeachingEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class TeachingEffectController {

    @Autowired
    private TeachingEffectService teachingEffectService;

    /**
     * 校外专家评价查询
     * @param page
     * @return
     */
//    @RequestMapping(value = "/xiaowaizhuanjia/{page}",method = {RequestMethod.POST})
    @RequestMapping(value = "/xiaowaizhuanjia/{page}",method = {RequestMethod.POST})
    public String selectAllMeasure(@PathVariable("page") String page) {
        //System.out.println("aaaa");
        List<ExpertComment> allComment=teachingEffectService.selectAllComment();
        int anInt = Integer.parseInt(page);
        List<ExpertComment> comments = new ArrayList<>();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allComment.size(); i++){
            comments.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allComment.size()%9==0?0:1;

        jsonObject.put("page",allComment.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",comments);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/xiaoneidudaopingjia/{page}",method = {RequestMethod.POST})
    public String selectAllLeaderComment(@PathVariable("page") String page) {
        //System.out.println("aaaa");
        List<ExpertComment> allComment=teachingEffectService.selectAllLeaderComment();
        int anInt = Integer.parseInt(page);
        List<ExpertComment> comments = new ArrayList<>();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allComment.size(); i++){
            comments.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allComment.size()%9==0?0:1;

        jsonObject.put("page",allComment.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",comments);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/jiaoshiziwopingjia/{page}",method = {RequestMethod.POST})
    public String selectAllTeacherComment(@PathVariable("page") String page) {
        //System.out.println("aaaa");
        List<ExpertComment> allComment=teachingEffectService.selectAllTeacherComment();
        int anInt = Integer.parseInt(page);
        List<ExpertComment> comments = new ArrayList<>();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allComment.size(); i++){
            comments.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allComment.size()%9==0?0:1;

        jsonObject.put("page",allComment.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",comments);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/xiaoneixueshengpingjia/{page}",method = {RequestMethod.POST})
    public String selectAllStudentComment(@PathVariable("page") String page) {
        //System.out.println("aaaa");
        List<ExpertComment> allComment=teachingEffectService.selectAllStudentComment();
        int anInt = Integer.parseInt(page);
        List<ExpertComment> comments = new ArrayList<>();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allComment.size(); i++){
            comments.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allComment.size()%9==0?0:1;

        jsonObject.put("page",allComment.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",comments);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/shehuipingjia/{page}",method = {RequestMethod.POST})
    public String selectAllSocialComment(@PathVariable("page") String page) {
        //System.out.println("aaaa");
        List<ExpertComment> allComment=teachingEffectService.selectAllSocialComment();
        int anInt = Integer.parseInt(page);
        List<ExpertComment> comments = new ArrayList<>();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allComment.size(); i++){
            comments.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allComment.size()%9==0?0:1;

        jsonObject.put("page",allComment.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",comments);
        return jsonObject.toJSONString();
    }
}

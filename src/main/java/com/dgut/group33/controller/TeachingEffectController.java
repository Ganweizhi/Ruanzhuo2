/**
 * 教学效果前台控制
 * @Author wjwwhs
 */
package com.dgut.group33.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group11.javabean.Contentb;
import com.dgut.group33.dao.TeachingEffectMapper;
import com.dgut.group33.javaBean.AddEditContent;
import com.dgut.group33.javaBean.ExpertComment;
import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.javaBean.MeasureContent;
import com.dgut.group33.service.TeachingEffectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
public class TeachingEffectController {

    @Autowired
    private TeachingEffectService teachingEffectService;
    @Autowired
    private TeachingEffectMapper teachingEffectMapper;

    //1--专家评价添加 2--监督 3--教师自我 4-校内学生 5--社会

    @RequestMapping(value="/dele-xiaoguo1/{id}",method = {RequestMethod.POST})
    public String delete1(@PathVariable("id") String id) {
        int content_id = Integer.parseInt(id);
        JSONObject jsonObject = new JSONObject();
        try {
            teachingEffectMapper.delete1(content_id);
            jsonObject.put("data", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("data", 0);
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/dele-xiaoguo2/{id}",method = {RequestMethod.POST})
    public String delete2(@PathVariable("id") String id) {
        int content_id = Integer.parseInt(id);
        JSONObject jsonObject = new JSONObject();
        try {
            teachingEffectMapper.delete2(content_id);
            jsonObject.put("data", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("data", 0);
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/dele-xiaoguo3/{id}",method = {RequestMethod.POST})
    public String delete3(@PathVariable("id") String id) {
        int content_id = Integer.parseInt(id);
        JSONObject jsonObject = new JSONObject();
        try {
            teachingEffectMapper.delete3(content_id);
            jsonObject.put("data", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("data", 0);
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/dele-xiaoguo4/{id}",method = {RequestMethod.POST})
    public String delete4(@PathVariable("id") String id) {
        int content_id = Integer.parseInt(id);
        JSONObject jsonObject = new JSONObject();
        try {
            teachingEffectMapper.delete4(content_id);
            jsonObject.put("data", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("data", 0);
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/dele-xiaoguo5/{id}",method = {RequestMethod.POST})
    public String delete5(@PathVariable("id") String id) {
        int content_id = Integer.parseInt(id);
        JSONObject jsonObject = new JSONObject();
        try {
            teachingEffectMapper.delete5(content_id);
            jsonObject.put("data", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("data", 0);
        }
        return jsonObject.toJSONString();
    }




    @RequestMapping(value="/edit-xiaoguo/{type}",method = {RequestMethod.POST})
    public String updateContentb(@PathVariable("type") String type2,@RequestBody ExpertComment expertComment){
        int type = Integer.parseInt(type2);
        JSONObject jsonObject = new JSONObject();
        try {
            if (type==1)
                teachingEffectMapper.edit1(expertComment);
            else if (type==2)
                teachingEffectMapper.edit2(expertComment);
            else if (type==3)
                teachingEffectMapper.edit3(expertComment);
            else if (type==4)
                teachingEffectMapper.edit4(expertComment);
            else if (type==5)
                teachingEffectMapper.edit5(expertComment);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/add-xiaoguo/{type}",method = {RequestMethod.POST})
    public String insert(@PathVariable("type") String type2,@RequestBody ExpertComment expertComment){
        int type = Integer.parseInt(type2);
        JSONObject jsonObject = new JSONObject();
        try {
            if (type==1)
                teachingEffectMapper.insert1(expertComment);
            else if (type==2)
                teachingEffectMapper.insert2(expertComment);
            else if (type==3)
                teachingEffectMapper.insert3(expertComment);
            else if (type==4)
                teachingEffectMapper.insert4(expertComment);
            else if (type==5)
                teachingEffectMapper.insert5(expertComment);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }
        return jsonObject.toJSONString();
    }

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
    //校外专家评价--展示所有
    @RequestMapping(value="/allzhuanjia",method = {RequestMethod.GET})
    public String allzhuanjia(@Param("page") int page, @Param("limit") int limit){
        List<ExpertComment> measure1=new ArrayList<>();
        List<ExpertComment> allComment=teachingEffectService.selectAllComment();
        for(int i=(page-1)*limit,j=i; i<j+limit && i< allComment.size(); i++){
            measure1.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",allComment.size());
        jsonObject.put("data",measure1);
        return jsonObject.toJSONString();

    }




    //校内督导
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
    //校内督导--展示所有
    @RequestMapping(value="/alljiandu",method = {RequestMethod.GET})
    public String alldudao(@Param("page") int page, @Param("limit") int limit){
        List<ExpertComment> measure1=new ArrayList<>();
        List<ExpertComment> allComment=teachingEffectService.selectAllLeaderComment();
        for(int i=(page-1)*limit,j=i; i<j+limit && i< allComment.size(); i++){
            measure1.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",allComment.size());
        jsonObject.put("data",measure1);
        return jsonObject.toJSONString();
    }



    //教师自我评价
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
    //教师自我评价--展示所有
    @RequestMapping(value="/alljiaoshi",method = {RequestMethod.GET})
    public String alljiaoshi(@Param("page") int page, @Param("limit") int limit){
        List<ExpertComment> measure1=new ArrayList<>();
        List<ExpertComment> allComment=teachingEffectService.selectAllTeacherComment();
        for(int i=(page-1)*limit,j=i; i<j+limit && i< allComment.size(); i++){
            measure1.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",allComment.size());
        jsonObject.put("data",measure1);
        return jsonObject.toJSONString();
    }


    //校内学生评价
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
    //校内学生评价--展示所有
    @RequestMapping(value="/allxuesheng",method = {RequestMethod.GET})
    public String allxuesheng(@Param("page") int page, @Param("limit") int limit){
        List<ExpertComment> measure1=new ArrayList<>();
        List<ExpertComment> allComment=teachingEffectService.selectAllStudentComment();
        for(int i=(page-1)*limit,j=i; i<j+limit && i< allComment.size(); i++){
            measure1.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",allComment.size());
        jsonObject.put("data",measure1);
        return jsonObject.toJSONString();
    }


    //社会评价
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

    //社会评价--展示所有
    @RequestMapping(value="/allshehui",method = {RequestMethod.GET})
    public String allshehui(@Param("page") int page, @Param("limit") int limit){
        List<ExpertComment> measure1=new ArrayList<>();
        List<ExpertComment> allComment=teachingEffectService.selectAllSocialComment();
        for(int i=(page-1)*limit,j=i; i<j+limit && i< allComment.size(); i++){
            measure1.add(allComment.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",allComment.size());
        jsonObject.put("data",measure1);
        return jsonObject.toJSONString();
    }

}

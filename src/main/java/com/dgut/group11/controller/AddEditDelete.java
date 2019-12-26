package com.dgut.group11.controller;


/*
lgc
 */

import com.alibaba.fastjson.JSONObject;
import com.dgut.group11.dao.AddEditDeleteDao;
import com.dgut.group11.dao.Teaching_ProgramDao;
import com.dgut.group11.javabean.*;
import com.dgut.group11.service.JiaoXueRiLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Contentb
Methodb
Planb
Problemb
RiLi
Teaching_program
 */

@RestController
@CrossOrigin(origins = "*")
public class AddEditDelete {

    @Autowired
    private AddEditDeleteDao addEditDeleteDao;
    @Autowired
    private JiaoXueRiLiService jiaoXueRiLiService;

    @RequestMapping(value="/listContentb",method = {RequestMethod.POST})
    public String listContentb(){

        List<Contentb> list = addEditDeleteDao.findAll1();

        for(Contentb l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listMethodb",method = {RequestMethod.POST})
    public String listMethodb(){

        List<Methodb> list = addEditDeleteDao.findAll2();

        for(Methodb l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listPlanb",method = {RequestMethod.POST})
    public String listPlanb(){

        List<Planb> list = addEditDeleteDao.findAll3();

        for(Planb l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(Integer.parseInt(l.getSuccess_id()));
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listProblemb",method = {RequestMethod.POST})
    public String listProblemb(){

        List<Problemb> list = addEditDeleteDao.findAll4();

        for(Problemb l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listCalendar",method = {RequestMethod.POST})
    public String listCalendar(){

        List<RiLi> list = addEditDeleteDao.findAll5();

        for(RiLi l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/listTeaching_program",method = {RequestMethod.POST})
    public String listTeaching_program(){

        List<Teaching_program> list = addEditDeleteDao.findAll6();

        for(Teaching_program l : list){
            SuccessCourse successCourse = jiaoXueRiLiService.findSuccessCourseById(l.getSuccess_id());
            Course course = jiaoXueRiLiService.getCourseById(successCourse.getCourse_id());
            l.setCourse_name(course.getCourse_name());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",list);
        return jsonObject.toJSONString();
    }




    @RequestMapping(value="/addContentb",method = {RequestMethod.POST})
    public String addContentb(@RequestBody Contentb contentb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.add1(contentb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/updateContentb",method = {RequestMethod.POST})
    public String updateContentb(@RequestBody Contentb contentb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.edit1(contentb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/deleteContentb",method = {RequestMethod.POST})
    public String deleteContentb(@RequestBody Contentb contentb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.delete1(contentb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/addMethodb",method = {RequestMethod.POST})
    public String addMethodb(@RequestBody Methodb methodb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.add2(methodb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/editMethodb",method = {RequestMethod.POST})
    public String editMethodb(@RequestBody Methodb methodb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.edit2(methodb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/deleteMethodb",method = {RequestMethod.POST})
    public String deleteMethodb(@RequestBody Methodb methodb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.delete2(methodb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/addPlanb",method = {RequestMethod.POST})
    public String addPlanb(@RequestBody Planb planb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.add3(planb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/editPlanb",method = {RequestMethod.POST})
    public String editPlanb(@RequestBody Planb planb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.edit3(planb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/deletePlanb",method = {RequestMethod.POST})
    public String deletePlanb(@RequestBody Planb planb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.delete3(planb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/addProblemb",method = {RequestMethod.POST})
    public String addProblemb(@RequestBody Problemb problemb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.add4(problemb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/editProblemb",method = {RequestMethod.POST})
    public String editProblemb(@RequestBody Problemb problemb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.edit4(problemb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/deleteProblemb",method = {RequestMethod.POST})
    public String deleteProblemb(@RequestBody Problemb problemb){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.delete4(problemb);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/addCalendar",method = {RequestMethod.POST})
    public String addCalendar(@RequestBody RiLi calendar){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.add5(calendar);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/editCalendar",method = {RequestMethod.POST})
    public String editCalendar(@RequestBody RiLi calendar){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.edit5(calendar);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/deleteCalendar",method = {RequestMethod.POST})
    public String deleteCalendar(@RequestBody RiLi calendar){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.delete5(calendar);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/addTeaching_program",method = {RequestMethod.POST})
    public String addTeaching_program(@RequestBody Teaching_program teaching_program){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.add6(teaching_program);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/editTeaching_program",method = {RequestMethod.POST})
    public String editTeaching_program(@RequestBody Teaching_program teaching_program){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.edit6(teaching_program);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }
    @RequestMapping(value="/deleteTeaching_program",method = {RequestMethod.POST})
    public String deleteTeaching_program(@RequestBody Teaching_program teaching_program){

        JSONObject jsonObject = new JSONObject();
        try {
            addEditDeleteDao.delete6(teaching_program);
            jsonObject.put("data",1);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("data",0);
        }


        return jsonObject.toJSONString();
    }





}

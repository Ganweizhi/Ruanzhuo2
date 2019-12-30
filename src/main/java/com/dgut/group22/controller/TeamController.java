package com.dgut.group22.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.javaBean.Team;
import com.dgut.group22.service.TeacherService;
import com.dgut.group22.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Ning
@RestController
@Transactional
@RequestMapping("/Team")
public class TeamController {
    @Autowired
    TeamService teamService;

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/findAllTeam/{page}",method = {RequestMethod.POST})
    public String findAllTeam(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<Team> teams = new ArrayList<>();
        List<Team> allTeams = teamService.findAll();

        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allTeams.size(); i++){
            teams.add(allTeams.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allTeams.size()%9==0?0:1;
        jsonObject.put("page",allTeams.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",teams);
//        System.out.println("11111111111111111"+teams.get(0).getCourse());
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/findTeacherByTeamId/{team_id}",method = {RequestMethod.POST})
    public String findTeacherByTeamId(@PathVariable("team_id")String team_id){
        List<Teacher> allTeachers=teamService.findTeacherByTeamId(team_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teachers",allTeachers);
        return jsonObject.toJSONString();
    }

    //找出所有教师团队
    @RequestMapping(value = "/findAllTeamAfter/{page}",method = {RequestMethod.POST})
    public String findAllTeamAfter(@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<Team> teams = new ArrayList<>();
        List<Team> allTeams = teamService.findAll();

        for(int i=(anInt-1)*5; i<(anInt-1)*5+5 && i<allTeams.size(); i++){
            teams.add(allTeams.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allTeams.size()%5==0?0:1;
        jsonObject.put("page",allTeams.size()/5+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("data",teams);
        return jsonObject.toJSONString();
    }

    //按id查出教师信息
    @RequestMapping(value = "findTeacherById/{teacher_id}",method = {RequestMethod.POST})
    public String findTeacherById(@PathVariable("teacher_id") String teacher_id){
        Teacher teacher=teacherService.findById(teacher_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teacher",teacher);
        return jsonObject.toJSONString();
    }

    //修改教师头像
    @RequestMapping(value = "/changeTeacherPhoto/{teacher_id}",method = {RequestMethod.POST})
    public String changeTeacherPhoto(MultipartFile upload,@PathVariable("teacher_id") String teacher_id){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try{
            String downloadFilePath =System.getProperty("user.dir");
            downloadFilePath =downloadFilePath+"\\src\\main\\resources\\teacherPhoto\\";
            File file = new File(downloadFilePath);
            if(!file.exists()){
                file.mkdirs();
            }
            String fileName = upload.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName = teacher_id+suffixName;
            upload.transferTo(new File(downloadFilePath,fileName));
            Teacher teacher = teacherService.findById(teacher_id);
            teacher.setTeacher_photo(fileName);
            teacherService.updateTeacher(teacher);
            flag="1";
        }
        catch (Exception e){
            flag="0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }

    //修改教师信息
    @RequestMapping(value = "/editTeacher",method = {RequestMethod.POST})
    public String editTeacher(Teacher teacher){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try{
            teacherService.updateTeacher(teacher);
        }
        catch (Exception e){
            flag="0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }
}

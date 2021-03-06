package com.dgut.group22.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/findTeacherByTeamId/{team_id}",method = {RequestMethod.POST})
    public String findTeacherByTeamId(@PathVariable("team_id")String team_id){
        List<Teacher> allTeachers=teamService.findTeacherByTeamId(team_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teachers",allTeachers);
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
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
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }

    //按id查出教师信息
    @RequestMapping(value = "/findTeacherById/{teacher_id}",method = {RequestMethod.POST})
    public String findTeacherById(@PathVariable("teacher_id") String teacher_id){
        Teacher teacher=teacherService.findById(teacher_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teacher",teacher);
        return jsonObject.toJSONString();
    }

    //在团队删除教师
    @RequestMapping(value = "/deleteTeacherFromTeam/{team_id}&{teacher_id}",method = {RequestMethod.POST})
    public String deleteTeacherFromTeam(@PathVariable("team_id") String team_id,@PathVariable("teacher_id") String teacher_id){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try {
            flag=teamService.deleteTeacher(teacher_id,team_id);
        }
        catch (Exception e){
            flag="0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else
            jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }

    //添加教师到团队
    @RequestMapping(value = "/addTeacherToTeam/{team_id}&{teacher_id}",method = {RequestMethod.POST})
    public String addTeacherToTeam(@PathVariable("team_id") String team_id,@PathVariable("teacher_id") String teacher_id){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        if(teamService.findTBelongT(team_id,teacher_id)==null) {
            try {
                flag = teamService.addTeacher(teacher_id, team_id);
            } catch (Exception e) {
                System.out.println(e);
                flag = "0";
            }
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else
            jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/addTeam",method = {RequestMethod.POST})
    public String addTeam(Team team){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try {
            flag = teamService.addTeam(team);
        } catch (Exception e) {
            System.out.println(e);
            flag = "0";
        }
        if(flag=="1")
            jsonObject.put("data","成功");
        else
            jsonObject.put("data","失败");
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/deleteTeam/{team_id}",method = {RequestMethod.POST})
    public String deleteTeam(@PathVariable("team_id") String team_id){
        String flag="0";
        JSONObject jsonObject = new JSONObject();
        try{
            teamService.deleteTeam(team_id);
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
}

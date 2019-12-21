package com.dgut.group22.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.javaBean.Team;
import com.dgut.group22.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Ning
@RestController
@Transactional
@RequestMapping("/Team")
public class TeamController {
    @Autowired
    TeamService teamService;

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
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/findTeacherByTeamId/{team_id}&{page}",method = {RequestMethod.POST})
    public String findTeacherByTeamId(@PathVariable("team_id")String team_id,@PathVariable("page") String page){
        int anInt = Integer.parseInt(page);
        List<Teacher> teachers=new ArrayList<>();
        List<Teacher> allTeachers=teamService.findTeacherByTeamId(team_id);
        for(int i=(anInt-1)*9; i<(anInt-1)*9+9 && i<allTeachers.size(); i++){
            teachers.add(allTeachers.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        int r = allTeachers.size()%9==0?0:1;
        jsonObject.put("page",allTeachers.size()/9+r);
        jsonObject.put("curPage",anInt);
        jsonObject.put("teachers",teachers);
        return jsonObject.toJSONString();
    }
}

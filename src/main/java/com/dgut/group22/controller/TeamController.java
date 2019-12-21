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
}

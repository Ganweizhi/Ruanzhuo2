package com.dgut.group22.service;

import com.dgut.group22.dao.ITeamDao;
import com.dgut.group22.javaBean.TBelongT;
import com.dgut.group22.javaBean.Teacher;
import com.dgut.group22.javaBean.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Ning
@Service
public class TeamService {
    @Autowired
    ITeamDao teamDao;

    public String deleteTeacher(String teacher_id,String team_id) {
        teamDao.deleteTeacher(teacher_id,team_id);
        return "1";
    }

    public List<Team> findAll(){
        return teamDao.findAllTeam();
    }

    public List<Teacher> findTeacherByTeamId(String TeamId){
        return teamDao.findTeacherByTeamId(TeamId);
    }

    public String addTeacher(String teacher_id, String team_id) {
        teamDao.addTeacher(teacher_id,team_id);
        return "1";
    }

    public TBelongT findTBelongT(String team_id,String teacher_id){
        return teamDao.findTBelongT(team_id,teacher_id);
    }

    public String addTeam(Team team){
        teamDao.addTeam(team);
        return "1";
    }
}

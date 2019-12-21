package com.dgut.group22.service;

import com.dgut.group22.dao.ITeamDao;
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

    public List<Team> findAll(){
        return teamDao.findAllTeam();
    }

    public List<Teacher> findTeacherByTeamId(String TeamId){
        return teamDao.findTeacherByTeamId(TeamId);
    }
}

package com.dgut.group33.service;

import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.dao.AchievementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService{
    @Autowired
    private AchievementMapper achievementMapper;

    public List<Measure> selectAllAchievement() {
        return achievementMapper.select();
    }

    public Measure selectA(int content_id){
        return achievementMapper.selectA(content_id);
    }

    public void delete(int achievement_id){achievementMapper.delete(achievement_id);}

    public void insert(Measure measure){achievementMapper.insert(measure);}

    public void update(Measure measure){achievementMapper.update(measure);}
}

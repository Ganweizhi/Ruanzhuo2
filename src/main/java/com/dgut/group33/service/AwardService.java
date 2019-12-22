package com.dgut.group33.service;

import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.dao.AwardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService{
    @Autowired
    private AwardMapper awardMapper;

    public List<Measure> selectAllAward() {
        return awardMapper.select();
    }

    public Measure selectA(int content_id){
        return awardMapper.selectA(content_id);
    }

    public void delete(int achievement_id){awardMapper.delete(achievement_id);}

    public void insert(Measure measure){awardMapper.insert(measure);}

    public void update(Measure measure){awardMapper.update(measure);}
}

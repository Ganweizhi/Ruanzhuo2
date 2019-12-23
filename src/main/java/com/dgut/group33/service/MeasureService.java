package com.dgut.group33.service;

import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.dao.MeasureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureService {
    @Autowired
    private MeasureMapper measureMapper;

    public List<Measure> selectAllMeasure() {
        return measureMapper.select();
    }

    public Measure selectA(int content_id){
        return measureMapper.selectA(content_id);
    }

    public void delete(int achievement_id){measureMapper.delete(achievement_id);}

    public void insert(Measure measure){measureMapper.insert(measure);}

    public void update(Measure measure){measureMapper.update(measure);}
}

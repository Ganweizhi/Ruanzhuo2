package com.dgut.group33.service;

import com.dgut.group33.dao.ContentMapper;
import com.dgut.group33.javaBean.MeasureContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContentService{
    @Autowired
    private ContentMapper contentMapper;

    public MeasureContent selectA(int content_id) {
        return contentMapper.selectA(content_id);
    }

    public void delete(int content_id){contentMapper.delete(content_id);}

    public void insert(MeasureContent content){contentMapper.insert(content);}

    public void update(MeasureContent content){contentMapper.update(content);}
}

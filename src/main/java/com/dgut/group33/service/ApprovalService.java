package com.dgut.group33.service;

import com.dgut.group33.javaBean.AddEditContent;
import com.dgut.group33.javaBean.Measure;
import com.dgut.group33.dao.ApprovalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalService{
    @Autowired
    private ApprovalMapper approvalMapper;

    public List<Measure> selectAllApproval() {
        return approvalMapper.select();
    }

    public Measure selectA(int content_id){
        return approvalMapper.selectA(content_id);
    }

    public void delete(int achievement_id){approvalMapper.delete(achievement_id);}

    public void insert(AddEditContent measure){approvalMapper.insert(measure);}

    public void update(AddEditContent measure){approvalMapper.update(measure);}
}

package com.dgut.service;

import com.dgut.jsonBean.DepartmentBean;
import com.dgut.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper DepartmentMapper;

    public List<DepartmentBean> findAll() {
        return DepartmentMapper.findAll();
    }

}

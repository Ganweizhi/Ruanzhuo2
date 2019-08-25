package com.dgut.service;

import com.dgut.jsonBean.GllistBean;
import com.dgut.mapper.ManagersMapper;
import com.dgut.model.staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WuJiewei
 * 调用mapper层接口
 */
@Service
public class ManagersService {

    @Autowired
    private ManagersMapper managersMapper;

    public List<GllistBean> findAll() {
        return managersMapper.findAll();
    }
}

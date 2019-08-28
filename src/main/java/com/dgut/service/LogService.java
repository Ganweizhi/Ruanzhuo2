package com.dgut.service;

import com.dgut.jsonBean.LogBean;
import com.dgut.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogMapper logmapper;

    public List<LogBean> findList(String gid, String name, String ip) {
        return logmapper.findList( gid,name,ip);
    }

    public int add(LogBean bean) {
        System.out.println(bean);
        return logmapper.add(bean);
    }

}

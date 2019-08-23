package com.dgut.service;

import com.dgut.jsonBean.htlistBean;
import com.dgut.mapper.UserFileMapper;
import com.dgut.model.UserFileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFileService {
    @Autowired
    private UserFileMapper userFileMapper;
//    public List<UserFileModel> selectAll()
//    {
//        return userFileMapper.selectAll();
//    }
    public List<htlistBean> findAll(String department,String degree,String search,String currentPage)
    {
        return userFileMapper.findList(department,degree,search,currentPage);
    }
    public int result(String wid,String htName)
    {
      UserFileModel um =  userFileMapper.findHt(wid,htName);
       if(um==null) return 0;
       else userFileMapper.deleteHt(wid,htName);
       return  1;
    }
}

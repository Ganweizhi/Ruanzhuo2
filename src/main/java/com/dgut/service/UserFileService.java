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
       UserFileModel um =  userFileMapper.findHt(wid,htName); //调用查询方法，判断有无该合同
       if(um==null) return 0;
       else userFileMapper.deleteHt(wid,htName); //有该合同调用此方法删除该合同
       return  1;
    }
}

package com.dgut.service;

import com.dgut.jsonBean.htlistBean;
import com.dgut.mapper.UserFileMapper;
import com.dgut.model.UserFileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.util.List;

@Service
public class UserFileService {
    @Autowired
    private UserFileMapper userFileMapper;
//    public List<UserFileModel> selectAll()
//    {
//        return userFileMapper.selectAll();
//    }
    public List<htlistBean> findAll(String department,String degree,String search)
    {
        return userFileMapper.findList1(department,degree,search);
    }
    public int result(String wid,String htName)
    {
       UserFileModel um =  userFileMapper.findHt(wid,htName); //调用查询方法，判断有无该合同
       if(um==null) return 0;
       else userFileMapper.deleteHt(wid,htName); //有该合同调用此方法删除该合同
       return  1;
    }
    public int saveImage(String wid,String fileId,String fileName,String fileSize,String fileClass){
        int i =0;
        userFileMapper.insertfile(wid, fileId, fileName, fileSize, fileClass);
       UserFileModel ufm = userFileMapper.findHt(wid,fileName);
       if(ufm == null) i =0;
       else  i = 1;
       return  i;
    }
}

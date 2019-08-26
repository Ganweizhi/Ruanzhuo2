package com.dgut.service;

import com.dgut.mapper.UserFileMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFileService {
    @Autowired
    private UserFileMapper userFileMapper;
    public int htInsert(String wid,String hid,String hname,String hurl,String usetime,String signingtime)
    {
        userFileMapper.htInsert(wid, hid, hname, hurl, usetime, signingtime);
        return 1;
    }
    public int htSum(String wid)
    {
        return userFileMapper.htSum(wid);
    }
    public void SetImg(String wid,String imgUrl)
    {
        userFileMapper.ImgUpdate(wid, imgUrl);
    }
    public void SetSfzz(String wid ,String url)
    {
        userFileMapper.SfzzUpdate(wid, url);
    }
    public void SetSfzf(String wid,String url)
    {
        userFileMapper.SfzfUpdate(wid,url);
    }
    public void SetYhkz(String wid,String url)
    {
        userFileMapper.YhkzUpdate(wid,url);
    }
    public void SetYhkf(String wid,String url)
    {
        userFileMapper.YhkfUpdate(wid,url);
    }
}

package com.dgut.service;

import com.dgut.jsonBean.htTable;
import com.dgut.mapper.UserFileMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserFileService {
    @Autowired
    private UserFileMapper userFileMapper;
    public int htInsert(String wid,String hid,String hname,String hurl,String usetime,String signingtime)
    {
        userFileMapper.htInsert(wid, hid, hname, hurl, usetime, signingtime);
        userFileMapper.updateDtime(wid,null); //上传合同后，将离职时间变空
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
    public void htDelete(String wid, String hid)
    {
        userFileMapper.htDelete(wid,hid);
    }
    public String findHtUrl(String wid,String hid)
    {
        return  userFileMapper.findHtUrl(wid,hid);
    }
    public List<htTable> htTables(String wid){
       return  userFileMapper.htTale(wid);
    }
    public String timeChange(String s){
        if(s.equals("Jan")) return "01";
        else if(s.equals("Feb")) return "02";
        else if(s.equals("Mar")) return "03";
        else if(s.equals("Apr")) return "04";
        else if(s.equals("May")) return "05";
        else if(s.equals("Jan")) return "06";
        else if(s.equals("Jul")) return "07";
        else if(s.equals("Aug")) return "08";
        else if(s.equals("Sep")) return "09";
        else if(s.equals("Oct")) return "10";
        else if(s.equals("Nov")) return "11";
        else return "12";
    }
    public int CalTime(String q,String  b) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        int a = Integer.parseInt(q);
        a = a*-1;
        rightNow.add(Calendar.MONTH,a); //减去合同月份
        Date nowC = rightNow.getTime();
        String nowString = sdf.format(nowC);
        //System.out.println(nowString);
        //System.out.println(b.compareTo(nowString));
        int w = b.compareTo(nowString);
        if(w>=0) return 1;
        else  return  0;
    }
}

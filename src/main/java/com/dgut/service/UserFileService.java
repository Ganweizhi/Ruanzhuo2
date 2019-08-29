package com.dgut.service;

import com.dgut.jsonBean.htTable;
import com.dgut.mapper.UserFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dgut.util.Method.*;

@Service
public class UserFileService {
    @Autowired
    private UserFileMapper userFileMapper;
    public int htInsert(String wid,String hid,String hname,String hurl,String usetime,String signingtime)
            throws Exception
    {
      userFileMapper.htInsert(wid, hid, hname, hurl, usetime, signingtime);
        int i = CompareTime(usetime,signingtime);
        if(i==1) {//新上传合同有效，刷新离职时间
            userFileMapper.updateDtime(wid, null); //将离职时间变空
           List<htTable> list = userFileMapper.htTale(wid);
           for(htTable date:list){
               int j = userFileMapper.isExsistInPht(date.getHid());
               if(j==0) {
                   if(!date.getHid().equals(hid)) { //除去新合同的HID
                       userFileMapper.PhtInsert(date.getHid());//将老HID插入PHT表
                   }
               }
           }
            return 1;
        }
        else {
            userFileMapper.PhtInsert(hid); //将无效合同的HID插入无效合同表PHT
            return 1;//新上传合同无效，只上传不刷新离职时间
        }
    }
    public int htSum(String wid)
    {
        int a = 0 ;
        List<htTable> list  = userFileMapper.htSum(wid);
        if(list.size()==0) return 0;
        else {
            int i = list.size();
           String str = list.get(i-1).getHid();
           a = Integer.parseInt(str.substring((str.lastIndexOf("_")+1)));
            return a;
        }
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
    public void htDelete(String hid)
    {
        userFileMapper.htDelete(hid); //删除HT表数据
        userFileMapper.PhtDelete(hid);//删除PHT表数据
    }
    public String findHtUrl(String wid,String hid)
    {
       List<htTable> list = userFileMapper.findHtUrl(wid,hid);
       String str = list.get(0).gethUrl();
       return str;
    }
    public List<htTable> htTables(String wid){
       return  userFileMapper.htTale(wid);
    }
   public int checkDepartureTime(String wid){
        String str = userFileMapper.checkDepartureTime(wid);
        if(str==null)
            return 1;
        else return 0;
   }
   public int isExisitInPht(String hid){
        int i=0;
       i = userFileMapper.isExsistInPht(hid);
       if(i>0) return 1; //PHT表不存在该HID，即该合同没有过期
       else  return 0;
   }

   public void setHidToPHT(String wid)throws  Exception{
        String str = userFileMapper.checkDepartureTime(wid);
        List<htTable> list = userFileMapper.htTale(wid);
        if(str==null) {
            for (htTable date : list) {
                int i = CompareTime(date.getUseTime(), date.getSigningTime());
                if (i == 0) {
                    int j = userFileMapper.isExsistInPht(date.getHid());
                    if (j == 0) {
                        userFileMapper.PhtInsert(date.getHid());
                    }
                }
            }
        }else {
            for (htTable date : list) {
                int j = userFileMapper.isExsistInPht(date.getHid());
                if(j==0){
                    userFileMapper.PhtInsert(date.getHid());
                }
            }
        }
    }

}

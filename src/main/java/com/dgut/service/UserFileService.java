package com.dgut.service;

import com.dgut.jsonBean.htTable;
import com.dgut.mapper.UserFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
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
  //  public void UpdateTime(String wid,String state){
   //     userFileMapper.updateDtime(wid,null);
   // }
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
        userFileMapper.htDelete(hid);
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
        if(w>=0) return 1;//合同有效
        else  return  0;  //合同无效
    }
   public int checkDepartureTime(String wid){
        String str = userFileMapper.checkDepartureTime(wid);
        if(str==null)
            return 1;
        else return 0;
   }
   public String calHtTime(String wid) throws  Exception{
       htTable hb =  userFileMapper.findCurrentHt(wid);
       int i =  CalTime(hb.getUseTime(),hb.getSigningTime());
       if(i==1) return  hb.getHid();//返回当前有效合同的hid;
       else return "全都无效";
   }
}

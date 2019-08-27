package com.dgut.controller;

import com.dgut.jsonBean.IdReturnBean;
import com.dgut.jsonBean.Inithtlist;
import com.dgut.jsonBean.htTable;
import com.dgut.jsonBean.htTable1;
import com.dgut.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class fileTestController {
    @Autowired
    private UserFileService userFileService;
    @Autowired
    private com.dgut.service.listService listService;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping(value = "/headimg")
    public String saveHeadimg(String wid,MultipartFile file) throws Exception
    {
        String realPath = request.getServletContext().getRealPath("/img/headimg");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid+ oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
//        String url = "img/headimg/" + newName;
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/headimg/" + newName;
        System.out.println(url);
        userFileService.SetImg(wid,url); //更新staff表的头像
        return "{\"success\":1,\"url\":\""+ url + "\"}";
    }
    @RequestMapping(value = "/htfile" )
   // public String saveHtFile(MultipartFile file,@ModelAttribute  Inithtlist iht) throws IOException
   public String saveHtFile( Inithtlist iht, MultipartFile file) throws Exception
    {

        System.out.println(iht);
        System.out.println(file.getOriginalFilename());
        String realPath = request.getServletContext().getRealPath("/img/HT");
//        String stime = iht.getSigningTime().substring(0,29);
//        String change = iht.getSigningTime().substring(29,33);
//        String last = change.substring(0,2)+":"+change.substring(2);
//        stime=stime+last;
        String time = iht.getSigningTime();
        String yuefen = userFileService.timeChange(time.substring(4,7));
        String stime1 = time.substring(11,15)+"-"+yuefen+"-"+time.substring(8,10);
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        int i = userFileService.htSum(iht.getWid())+1;
        String HID = iht.getWid()+"_"+i;
        String oldName = file.getOriginalFilename();
        String newName = HID+ oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/HT/" + newName;
        userFileService.htInsert(iht.getWid(),HID,iht.getHtName(),url,iht.getUseTime(),stime1);
        //userFileService.htInsert(iht.getWid().toString(),"123",iht.getHtName(),"56",iht.getUseTime(),stime1);
        System.out.println(url);
       return "{\"success\":1}";
    }
    @RequestMapping(value = "/sfzz",method = RequestMethod.POST)
    public IdReturnBean SaveSfzz(String wid ,MultipartFile file) throws IOException
    {
        String realPath = request.getServletContext().getRealPath("/img/SFZZ");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid+"_sfz_zm"+ oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/SFZZ/" + newName;
        System.out.println(url);
        userFileService.SetSfzz(wid,url);
        IdReturnBean IB = new IdReturnBean("sfzz",newName,url);
        return IB;
    }
    @RequestMapping(value = "/sfzf",method = RequestMethod.POST)
    public IdReturnBean SaveSfzf(String wid,MultipartFile file)throws IOException
    {
        String realPath = request.getServletContext().getRealPath("/img/SFZF");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid+"_sfz_fm"+ oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/SFZF/" + newName;
        System.out.println(url);
        userFileService.SetSfzf(wid,url);
        IdReturnBean IB = new IdReturnBean("sfzf",newName,url);
        return IB;
    }
    @RequestMapping(value="/yhkz",method = RequestMethod.POST)
    public IdReturnBean SaveBankZm(String wid,MultipartFile file)throws  IOException{
        String realPath = request.getServletContext().getRealPath("/img/BankId/Z");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid+"_yhk_zm"+ oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/BankId/Z/" + newName;
        System.out.println(url);
        userFileService.SetYhkz(wid,url);
        IdReturnBean IB = new IdReturnBean("yhkz",newName,url);
        return IB;
    }
    @RequestMapping(value="/yhkf",method = RequestMethod.POST)
    public IdReturnBean SaveBankFm(String wid,MultipartFile file)throws  IOException{
        String realPath = request.getServletContext().getRealPath("/img/BankId/F");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid+"_yhk_fm"+ oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/BankId/F/" + newName;
        System.out.println(url);
        userFileService.SetYhkf(wid,url);
        IdReturnBean IB = new IdReturnBean("yhkf",newName,url);
        return IB;
    }
    @RequestMapping(value = "/htdelete")
    public String htDelete(String wid,String hid)
    {
        userFileService.htDelete(wid, hid);
        String realPath = request.getServletContext().getRealPath("/img/HT");
        String S = userFileService.findHtUrl(wid,hid);
        realPath = realPath+S.substring(S.lastIndexOf("/"));
        File file = new File(realPath);
        if(file.exists())
        {
            file.delete();
            return "{\"success\":1}";
        }
        else return "{\"success\":0}";
    }
    @RequestMapping(value="/httable")
    public List<htTable1> htTbale1s1(String wid) throws Exception
    {
      List<htTable> list = userFileService.htTables(wid);
      int State[] = new int[list.size()];
      List<htTable1> list1 = new ArrayList<htTable1>();
      for(htTable date :list){
          int i = 0 ;
          State[i] =userFileService.CalTime(date.getUseTime(),date.getSigningTime());
         htTable1 hb = new htTable1(date.getHid(),date.gethName(),date.getSigningTime(),date.getSigningTime(),date.gethUrl(),State[i]);
         list1.add(hb);
         i++;
     }
     return list1;
    }
}

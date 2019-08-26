package com.dgut.controller;

        import com.dgut.jsonBean.IdReturnBean;
        import com.dgut.jsonBean.Inithtlist;
        import com.dgut.service.UserFileService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

        import javax.servlet.http.HttpServletRequest;
        import java.io.File;
        import java.io.IOException;
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
        return "{\"success\":1}";
    }
    @RequestMapping(value = "/htfile" ,method = RequestMethod.POST)
    public String saveHtFile(MultipartFile file,@RequestBody Inithtlist iht) throws IOException
   // public String saveHtFile(@RequestBody Inithtlist iht, MultipartFile file) throws IOException
    {
        String realPath = request.getServletContext().getRealPath("/img/HT");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        int i = userFileService.htSum(iht.getWid())+1;
        String HID = iht.getWid()+"_"+i;
        String oldName = file.getOriginalFilename();
        String newName = HID+ oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String HURL = realPath+"/"+newName;
        userFileService.htInsert(iht.getWid(),HID,iht.getHtname(),HURL,iht.getUseTime(),iht.getSigningTime());
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/HT/" + newName;
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
}

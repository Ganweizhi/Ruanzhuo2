package com.dgut.controller;

        import ch.qos.logback.core.util.FileUtil;
        import com.dgut.jsonBean.IdReturnBean;
        import com.dgut.jsonBean.Inithtlist;
        import com.dgut.jsonBean.htTable;
        import com.dgut.jsonBean.htTable1;
        import com.dgut.service.UserFileService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.core.io.ClassPathResource;
        import org.springframework.core.io.InputStreamResource;
        import org.springframework.http.HttpHeaders;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.util.ResourceUtils;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

        import javax.annotation.Resource;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.*;
        import java.util.*;

        import static com.dgut.util.Method.*;

@RestController
@CrossOrigin(origins = "*")
public class fileTestController {
    @Autowired
    private UserFileService userFileService;
    @Autowired
    private com.dgut.service.listService listService;
    @Autowired
    private HttpServletRequest request;
    private HttpServletResponse Res;
    @RequestMapping(value = "/headimg")
    public String saveHeadimg(String wid, MultipartFile file) throws Exception {
        String realPath = request.getServletContext().getRealPath("/img/headimg");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder, newName));
//        String url = "img/headimg/" + newName;
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/headimg/" + newName;
        System.out.println(url);
        userFileService.SetImg(wid, url); //更新staff表的头像
        return "{\"success\":1,\"url\":\"" + url + "\"}";
    }

    @RequestMapping(value = "/htfile")
    public String saveHtFile(Inithtlist iht, MultipartFile file) throws Exception {

        //System.out.println(iht);
        //System.out.println(file.getOriginalFilename());
        String realPath = request.getServletContext().getRealPath("/img/HT");
        String time = iht.getSigningTime();
        String yuefen = timeChange(time.substring(4, 7));
        String signingTime = time.substring(11, 15) + "-" + yuefen + "-" + time.substring(8, 10);
        //将前端发送时间转化为yyyy-MM-dd型
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        int i = userFileService.htSum(iht.getWid()) + 1;//计算合同HID
        String HID = iht.getWid() + "_" + i;
        String oldName = file.getOriginalFilename();
        String newName = HID + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder, newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/HT/" + newName;
        userFileService.htInsert(iht.getWid(), HID, iht.getHtName(), url, iht.getUseTime(), signingTime);
        //插入数据库，并且在htInsert函数里判断合同是否有效
        System.out.println(url);
        return "{\"success\":1}";
    }

    @RequestMapping(value = "/sfzz", method = RequestMethod.POST)
    public IdReturnBean SaveSfzz(String wid, MultipartFile file) throws IOException {
        String realPath = request.getServletContext().getRealPath("/img/SFZZ");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid + "_sfz_zm" + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder, newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/SFZZ/" + newName;
        System.out.println(url);
        userFileService.SetSfzz(wid, url);
        IdReturnBean IB = new IdReturnBean("sfzz", newName, url);
        return IB;
    }

    @RequestMapping(value = "/sfzf", method = RequestMethod.POST)
    public IdReturnBean SaveSfzf(String wid, MultipartFile file) throws IOException {
        String realPath = request.getServletContext().getRealPath("/img/SFZF");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid + "_sfz_fm" + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder, newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/SFZF/" + newName;
        System.out.println(url);
        userFileService.SetSfzf(wid, url);
        IdReturnBean IB = new IdReturnBean("sfzf", newName, url);
        return IB;
    }

    @RequestMapping(value = "/yhkz", method = RequestMethod.POST)
    public IdReturnBean SaveBankZm(String wid, MultipartFile file) throws IOException {
        String realPath = request.getServletContext().getRealPath("/img/BankId/Z");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid + "_yhk_zm" + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder, newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/BankId/Z/" + newName;
        System.out.println(url);
        userFileService.SetYhkz(wid, url);
        IdReturnBean IB = new IdReturnBean("yhkz", newName, url);
        return IB;
    }

    @RequestMapping(value = "/yhkf", method = RequestMethod.POST)
    public IdReturnBean SaveBankFm(String wid, MultipartFile file) throws IOException {
        String realPath = request.getServletContext().getRealPath("/img/BankId/F");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid + "_yhk_fm" + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder, newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/BankId/F/" + newName;
        System.out.println(url);
        userFileService.SetYhkf(wid, url);
        IdReturnBean IB = new IdReturnBean("yhkf", newName, url);
        return IB;
    }

    @RequestMapping(value = "/htdelete")
    public String htDelete(String wid, String hid) throws Exception
    {
        String realPath = "/img/HT";
        String S = userFileService.findHtUrl(wid, hid);
        realPath = realPath + S.substring(S.lastIndexOf("/"));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/HT/" + S.substring(S.lastIndexOf("/"));
        String absolutePath = ResourceUtils.getURL("src/main/webapp").getPath();
        realPath = absolutePath + realPath;
        realPath = realPath.substring(1);
        File file = new File(realPath);
        if (file.exists()) {
            file.delete();
            userFileService.htDelete(hid);
            return "{\"success\":1}";
        } else {
            System.out.println(realPath);
            return "{\"success\":0}";
        }
    }
    @RequestMapping(value = "/httable")
     public List<htTable1> htTbale1s(String wid) throws Exception {

        userFileService.setHidToPHT(wid);//先调用此方法
        List<htTable> list = userFileService.htTables(wid);
        List<htTable1> list1 = new ArrayList<htTable1>();
        for(htTable date:list){
            int i = userFileService.isExisitInPht(date.getHid());
            if(i==0){
                htTable1 hb = new htTable1(date.getHid(),date.gethName(),date.getSigningTime(),date.getUseTime(),date.gethUrl(),1);
                list1.add(hb);
            }
            else{
                htTable1 hb = new htTable1(date.getHid(),date.gethName(),date.getSigningTime(),date.getUseTime(),date.gethUrl(),0);
                list1.add(hb);
            }
        }
        return list1;
    }
//    @RequestMapping("/download")
//    @ResponseBody
//    public void Download(HttpServletResponse response) {
//        String realPath = "user.xlsx";
//        String result =downloadFile(response,realPath);
//        System.out.println(result);
//    }
//    @RequestMapping("/download")
//    public void down(HttpServletResponse response){
//        String PATH ="download";
//        String FILENAME = "user.xlsx";
//        String NEWNAME ="";
//        downloadFile(response,FILENAME);
//    }
//    public  String downloadFile(HttpServletResponse response,String fileName) {
//        String realPath = request.getServletContext().getRealPath("/img/download/");
//        InputStream stream = FileUtil.class.getClassLoader().getResourceAsStream(realPath + fileName);
//      //  InputStream stream = this.getClass().getResourceAsStream(realPath+f);
//        System.out.println(stream);
//        System.out.println(realPath);
//        response.setHeader("content-type", "application/octet-stream");
//        response.setContentType("application/octet-stream");
//        try {
//            String name = java.net.URLEncoder.encode(fileName, "UTF-8");
//            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLDecoder.decode(name, "ISO-8859-1") );
//        } catch (UnsupportedEncodingException e2) {
//            e2.printStackTrace();
//        }
//        byte[] buff = new byte[1024];
//        BufferedInputStream bis = null;
//        OutputStream os = null;
//        try {
//            os = response.getOutputStream();
//            bis = new BufferedInputStream(stream);
//            int i = bis.read(buff);
//            while (i != -1) {
//                os.write(buff, 0, buff.length);
//                os.flush();
//                i = bis.read(buff);
//            }
//        } catch (FileNotFoundException e1) {
//            //e1.getMessage()+"系统找不到指定的文件";
//            return "系统找不到指定的文件";
//        }catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (bis != null) {
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return "success";
//    }
@RequestMapping("/download")
private String downloadFile(HttpServletResponse response){
   String  realPath = request.getServletContext().getRealPath("/img/download/");
//String downloadFilePath = "/img/download/";//被下载的文件在服务器中的路径,
   String fileName = "test.xlsx";//被下载文件的名称
   String downloadFilePath =realPath+fileName;

   File file = new File(downloadFilePath);
   if (file.exists()) {
       response.setContentType("application/force-download");// 设置强制下载不打开            
      response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
      byte[] buffer = new byte[1024];
      FileInputStream fis = null;
     BufferedInputStream bis = null;
      try {
      fis = new FileInputStream(file);
      bis = new BufferedInputStream(fis);
      OutputStream outputStream = response.getOutputStream();
      int i = bis.read(buffer);
      while (i != -1) {
      outputStream.write(buffer, 0, i);
      i = bis.read(buffer);
   }

   return "下载成功";
   } catch (Exception e) {
        e.printStackTrace();
   } finally {
      if (bis != null) {
   try {
     bis.close();
    } catch (IOException e) {
     e.printStackTrace();
   }
}
    if (fis != null) {
     try {
     fis.close();
   } catch (IOException e) {
   e.printStackTrace();
   }
     }
   }
   }
   return "下载失败";
   }
}

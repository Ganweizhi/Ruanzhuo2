package com.dgut.controller;

        import com.dgut.jsonBean.htaddBean;
        import com.dgut.jsonBean.htlistBean;
        import com.dgut.jsonBean.htlistBeanpage;
        import com.dgut.model.UserFileModel;
        import com.dgut.service.UserFileService;
        import com.dgut.service.listService;
        import org.apache.ibatis.annotations.Param;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.context.request.RequestContextHolder;
        import org.springframework.web.context.request.ServletRequestAttributes;
        import org.springframework.web.multipart.MultipartFile;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.File;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Objects;
        import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class fileTestController {
    @Autowired
    private UserFileService userFileService;
    @Autowired
    private com.dgut.service.listService listService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/htfile")
    public String addht(MultipartFile file,@RequestBody htaddBean hb)throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
       String realPath = request.getServletContext().getRealPath("D:\\Personnel_Management_System2\\fileStatic");
       File foler = new File(realPath);
       if(!foler.exists())
       {
           foler.mkdir();
       }
       String fileSize = ""+file.getSize();
       String oldName = file.getOriginalFilename();
       String  newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
       file.transferTo(new File(foler,newName));
       int i = userFileService.saveImage(hb.getWid(),newName,newName,fileSize,"合同");
      if(i==0) return "{\"success\":0}";
      else  return "{\"success\":1}";
    }
    @RequestMapping(value = "/headimg")
    public String saveHeadimg(String wid,MultipartFile file) throws Exception
    {
        String realPath = request.getServletContext().getRealPath("/img");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = wid+ oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/" + newName;
        System.out.println(url);
        return "{\"success\":1}";
    }
}

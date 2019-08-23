package com.dgut.controller;

        import com.dgut.jsonBean.htlistBean;
        import com.dgut.jsonBean.htlistBeanpage;
        import com.dgut.model.UserFileModel;
        import com.dgut.service.UserFileService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.ArrayList;
        import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class fileTestController {
    @Autowired
    private UserFileService userFileService;
//    @RequestMapping("/htlist")
//    @ResponseBody
//    public htlistBeanpage getList()
//    {
//        List<UserFileModel> data = userFileService.selectAll();
//        List<htlistBean> list = new ArrayList<>();
//        int i = data.size();
//        for(int j=0;j<=i;j++)
//        {
//            String wid = ""+data.get(j).getWid();
//            htlistBean hb = new htlistBean(wid,data.get(j).getName(),data.get(j).getSex(),data.get(j).getDegree(),data.get(j).getDepartment(),i);
//            list.add(hb);
//        }
//        htlistBeanpage HtlistBeanpage = new htlistBeanpage();
//        HtlistBeanpage.setData(list);
//        if(i>=7&&i%7!=0) i=i/7+1;
//        else if(i<7) i=1;
//        else  i = i/7;
//        HtlistBeanpage.setTotalPage(i);
//        System.out.println(HtlistBeanpage.getData());
//        return HtlistBeanpage;
//    };
    @RequestMapping("/htlist")
    @ResponseBody
    public htlistBeanpage returnlist(String department,String degree,String search,String currentPage)
    {
        if(department.equals(""))
        {
            department = null;
        }
        if(degree.equals("")){
            degree=null;
        }
        if(search.equals("")){
            search=null;
        }
        if(currentPage.equals("")){
            currentPage=null;
        }
        List<htlistBean> data = userFileService.findAll(department,degree,search,currentPage);
        int start = (Integer.parseInt(currentPage)-1)*7;
        int end   = start+7>data.size()?data.size():start+7;
        List<htlistBean> data1 = data.subList(start,end);
        htlistBeanpage hp = new htlistBeanpage(data1,data1.size());
        return hp;
    }
   @RequestMapping("/htdelete")
    @ResponseBody
    public int result(String wid,String htName)
   {
     return userFileService.result(wid,htName);
   }
}

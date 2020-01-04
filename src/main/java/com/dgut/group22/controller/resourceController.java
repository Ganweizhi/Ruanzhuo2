package com.dgut.group22.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dgut.group22.javaBean.*;
import com.dgut.group22.service.VideoService;
import com.dgut.group22.service.resourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("/resource")
public class resourceController {

    @Autowired
    private resourceService resourceService;
    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/GetAllTextbook",method = RequestMethod.GET)
    @ResponseBody
    public List<String> GetAllTextbook(HttpServletRequest request) throws FileNotFoundException {
        List<String> strings=new ArrayList<String>();
//        File sourceFile= null;
        String path=null;
        List<resource> resources=resourceService.GetAllResource();
        for(resource resource: resources ){
            if(resource.getResource_textbook()!=null)
            strings.add(resource.getResource_textbook());
            String downloadFilePath =System.getProperty("user.dir");
//            downloadFilePath =downloadFilePath+"\\src\\main\\resources\\ppt";
//            String downloadFilePath = request.getSession().getServletContext().getRealPath("/");
            System.out.println(downloadFilePath);
//            path= request.getServletContext().getRealPath("/ppt/");//获取文件的路径
//            strings.add(path+resource.getResource_textbook());
        }
        return strings;
    }

    @RequestMapping("/downLoadFile")
    @ResponseBody
    private String downLoadFile(HttpServletResponse response ,HttpServletRequest request,String fileName){
        String downloadFilePath =System.getProperty("user.dir");
        downloadFilePath =downloadFilePath+"\\src\\main\\resources\\ppt\\";
//        String downloadFilePath = request.getServletContext().getRealPath("/ppt/");//被下载的文件在服务器中的路径,
//        String fileName = " ";
        System.out.println(fileName);
        System.out.println(downloadFilePath);
        File file = new File(downloadFilePath,fileName);
        System.out.println(file.getPath());
        System.out.println(file.exists());
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                System.out.println(fileName);
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

    @RequestMapping(value = "/GetAllBase",method = RequestMethod.GET)    //习题库
    @ResponseBody
    public List<String> GetAllBase(HttpServletRequest request) throws FileNotFoundException {
        List<String> strings=new ArrayList<String>();
        List<resource> resources=resourceService.GetAllResource();
        for(resource resource: resources ){
            if(resource.getResource_base()!=null)
                strings.add(resource.getResource_base());
        }
        return strings;
    }

    @RequestMapping(value = "/GetAllDocument",method = RequestMethod.GET)       //技术文档
    @ResponseBody
    public List<String> GetAllDocument(HttpServletRequest request) throws FileNotFoundException {
        List<String> strings=new ArrayList<String>();
        List<resource> resources=resourceService.GetAllResource();
        for(resource resource: resources ){
            if(resource.getResource_document()!=null)
                strings.add(resource.getResource_document());
        }
        return strings;
    }

    @RequestMapping(value = "/GetAllExperiment",method = RequestMethod.GET)
    @ResponseBody
    public List<String> GetAllExperiment(HttpServletRequest request) throws FileNotFoundException {
        List<String> strings=new ArrayList<String>();
        List<resource> resources=resourceService.GetAllResource();
        for(resource resource: resources ){
            if(resource.getResource_experiment()!=null)
                strings.add(resource.getResource_experiment());
        }
        return strings;
    }

    @RequestMapping(value = "/GetAllExperiment_house",method = RequestMethod.GET)
    @ResponseBody
    public List<String> GetAllExperiment_house(HttpServletRequest request) throws FileNotFoundException {
        List<String> strings=new ArrayList<String>();
        List<experiment_house> experiment_houses=resourceService.GetAllExperiment_house();
        for(experiment_house experiment_house: experiment_houses ){
            if(experiment_house.getExperiment_huanj()!=null)
                strings.add(experiment_house.getExperiment_huanj());
        }
        return strings;
    }

    @RequestMapping(value = "/UploadVideo",method = RequestMethod.POST)
    @ResponseBody
    public String UploadVideo(MultipartFile[] file, HttpServletRequest request, String course_name, String teacher_name){
        String code="0";
        System.out.println(course_name+teacher_name);
        SuccessCourse successCourse = resourceService.selectSuccessCourse(course_name,teacher_name);
        if(successCourse==null){
            code="400";
            return code;
        }
        try {
            //创建文件在服务器端存放路径
            String downloadFilePath = System.getProperty("user.dir");
            downloadFilePath =downloadFilePath+"\\src\\main\\resources\\video\\";
            File fileDir = new File(downloadFilePath);
            //生成文件在服务器端存放的名字
            for(int i=0; i<file.length; i++) {
                String fileName=file[i].getOriginalFilename();
                File files = new File(fileDir+"/"+fileName);
                //上传
                file[i].transferTo(files);
                resource resource = new resource();
                resource.setSuccess_id(successCourse.getSuccess_id());
                resource.setResource_video(fileName);
                resourceService.insertTextbook(resource);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return code;

    }

    @RequestMapping(value = "/UploadPPT",method = RequestMethod.POST)
    @ResponseBody
    public String UploadPPT(MultipartFile[] file, HttpServletRequest request, String course_name, String teacher_name){
        String code="0";
        System.out.println(course_name+teacher_name);
        SuccessCourse successCourse = resourceService.selectSuccessCourse(course_name,teacher_name);
        if(successCourse==null){
            code="400";
            return code;
        }
        try {
            //创建文件在服务器端存放路径
            String downloadFilePath = System.getProperty("user.dir");
            downloadFilePath =downloadFilePath+"\\src\\main\\resources\\ppt\\";
            File fileDir = new File(downloadFilePath);
            //生成文件在服务器端存放的名字
            for(int i=0; i<file.length; i++) {
                String fileName=file[i].getOriginalFilename();
                File files = new File(fileDir+"/"+fileName);
                //上传
                file[i].transferTo(files);
                resource resource = new resource();
                resource.setSuccess_id(successCourse.getSuccess_id());
                resource.setResource_textbook(fileName);
                resourceService.insertTextbook(resource);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return code;

    }

    @RequestMapping(value = "/UploadBase",method = RequestMethod.POST)
    @ResponseBody
    public String UploadBase(MultipartFile[] file, HttpServletRequest request, String course_name, String teacher_name){
        String code="0";
        System.out.println(course_name+teacher_name);
        SuccessCourse successCourse = resourceService.selectSuccessCourse(course_name,teacher_name);
        if(successCourse==null){
            code="400";
            return code;
        }
        try {
            //创建文件在服务器端存放路径
            String downloadFilePath = System.getProperty("user.dir");
            downloadFilePath =downloadFilePath+"\\src\\main\\resources\\ppt\\";
            File fileDir = new File(downloadFilePath);
            //生成文件在服务器端存放的名字
            for(int i=0; i<file.length; i++) {
                String fileName=file[i].getOriginalFilename();
                File files = new File(fileDir+"/"+fileName);
                //上传
                file[i].transferTo(files);
                resource resource = new resource();
                resource.setSuccess_id(successCourse.getSuccess_id());
                resource.setResource_base(fileName);
                resourceService.insertTextbook(resource);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return code;

    }

    @RequestMapping(value = "/UploadExperiment",method = RequestMethod.POST)
    @ResponseBody
    public String UploadExperiment(MultipartFile[] file, HttpServletRequest request, String course_name, String teacher_name){
        String code="0";
        System.out.println(course_name+teacher_name);
        SuccessCourse successCourse = resourceService.selectSuccessCourse(course_name,teacher_name);
        if(successCourse==null){
            code="400";
            return code;
        }
        try {
            //创建文件在服务器端存放路径
            String downloadFilePath = System.getProperty("user.dir");
            downloadFilePath =downloadFilePath+"\\src\\main\\resources\\ppt\\";
            File fileDir = new File(downloadFilePath);
            //生成文件在服务器端存放的名字
            for(int i=0; i<file.length; i++) {
                String fileName=file[i].getOriginalFilename();
                File files = new File(fileDir+"/"+fileName);
                //上传
                file[i].transferTo(files);
                resource resource = new resource();
                resource.setSuccess_id(successCourse.getSuccess_id());
                resource.setResource_experiment(fileName);
                resourceService.insertTextbook(resource);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return code;

    }

    @RequestMapping(value = "/UploadDocument",method = RequestMethod.POST)
    @ResponseBody
    public String UploadDocument(MultipartFile[] file, HttpServletRequest request, String course_name, String teacher_name){
        String code="0";
        System.out.println(course_name+teacher_name);
        SuccessCourse successCourse = resourceService.selectSuccessCourse(course_name,teacher_name);
        if(successCourse==null){
            code="400";
            return code;
        }
        try {
            //创建文件在服务器端存放路径
            String downloadFilePath = System.getProperty("user.dir");
            downloadFilePath =downloadFilePath+"\\src\\main\\resources\\ppt\\";
            File fileDir = new File(downloadFilePath);
            //生成文件在服务器端存放的名字
            for(int i=0; i<file.length; i++) {
                String fileName=file[i].getOriginalFilename();
                File files = new File(fileDir+"/"+fileName);
                //上传
                file[i].transferTo(files);
                resource resource = new resource();
                resource.setSuccess_id(successCourse.getSuccess_id());
                resource.setResource_document(fileName);
                resourceService.insertTextbook(resource);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return code;

    }

    @RequestMapping(value = "/UploadExperiment_house",method = RequestMethod.POST)
    @ResponseBody
    public String UploadExperiment_house(MultipartFile[] file, HttpServletRequest request, String course_name, String teacher_name){
        String code="0";
        System.out.println(course_name+teacher_name);
        SuccessCourse successCourse = resourceService.selectSuccessCourse(course_name,teacher_name);
        if(successCourse==null){
            code="400";
            return code;
        }
        List<resource> resources = new ArrayList<>();
        resources= resourceService.selectResourceBySuccess_id(successCourse.getSuccess_id());
        try {
            //创建文件在服务器端存放路径
            String downloadFilePath = System.getProperty("user.dir");
            downloadFilePath =downloadFilePath+"\\src\\main\\resources\\ppt\\";
            File fileDir = new File(downloadFilePath);
            //生成文件在服务器端存放的名字
            for(int i=0; i<file.length; i++) {
                String fileName=file[i].getOriginalFilename();
                File files = new File(fileDir+"/"+fileName);
                //上传
                file[i].transferTo(files);
                experiment_house experiment_house = new experiment_house();
                experiment_house.setResource_id(resources.get(0).getResource_id());
                experiment_house.setExperiment_huanj(fileName);
                resourceService.insertExperiment_house(experiment_house);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return code;

    }

    @RequestMapping(value = "/GetAlltextbook",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> GetAlltextbook(HttpServletRequest request) throws FileNotFoundException {
        List<resource> resourceList = new ArrayList<>();
        List<SuccessCourse> successCourseList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        List<resource> resources=resourceService.GetAllResource();
        Map<String, Object> map = new HashMap<>();
        for(resource resource: resources ){
            if(resource.getResource_textbook()!=null){
                resourceList.add(resource);
                SuccessCourse successCourse = resourceService.selectSuccessCourseById(resource.getSuccess_id());
                successCourseList.add(successCourse);
                Course course = resourceService.selectCourseById(successCourse.getCourse_id());
                courseList.add(course);
                Teacher teacher = resourceService.selectTeacherById(successCourse.getTeacher_id());
                teacherList.add(teacher);
            }
        }
        map.put("resourceList",resourceList);
//        map.put("successCourseList",successCourseList);
        map.put("courseList",courseList);
        map.put("teacherList",teacherList);
        return map;
    }

    @RequestMapping(value = "/GetAllvideo",method = RequestMethod.GET)     //教学视频
    @ResponseBody
    public Map<String, Object> GetAllvideo(HttpServletRequest request) throws FileNotFoundException {
        List<resource> resourceList = new ArrayList<>();
        List<SuccessCourse> successCourseList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        List<resource> resources=resourceService.GetAllResource();
        Map<String, Object> map = new HashMap<>();
        for(resource resource: resources ){
            if(resource.getResource_video()!=null){
                resourceList.add(resource);
                SuccessCourse successCourse = resourceService.selectSuccessCourseById(resource.getSuccess_id());
                successCourseList.add(successCourse);
                Course course = resourceService.selectCourseById(successCourse.getCourse_id());
                courseList.add(course);
                Teacher teacher = resourceService.selectTeacherById(successCourse.getTeacher_id());
                teacherList.add(teacher);
            }
        }
        map.put("resourceList",resourceList);
//        map.put("successCourseList",successCourseList);
        map.put("courseList",courseList);
        map.put("teacherList",teacherList);
        return map;
    }

    @RequestMapping(value = "/GetAllbase",method = RequestMethod.GET)     //习题库
    @ResponseBody
    public Map<String, Object> GetAllbase(HttpServletRequest request) throws FileNotFoundException {
        List<resource> resourceList = new ArrayList<>();
        List<SuccessCourse> successCourseList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        List<resource> resources=resourceService.GetAllResource();
        Map<String, Object> map = new HashMap<>();
        for(resource resource: resources ){
            if(resource.getResource_base()!=null){
                resourceList.add(resource);
                SuccessCourse successCourse = resourceService.selectSuccessCourseById(resource.getSuccess_id());
                successCourseList.add(successCourse);
                Course course = resourceService.selectCourseById(successCourse.getCourse_id());
                courseList.add(course);
                Teacher teacher = resourceService.selectTeacherById(successCourse.getTeacher_id());
                teacherList.add(teacher);
            }
        }
        map.put("resourceList",resourceList);
//        map.put("successCourseList",successCourseList);
        map.put("courseList",courseList);
        map.put("teacherList",teacherList);
        return map;
    }

    @RequestMapping(value = "/GetAllexperiment",method = RequestMethod.GET)     //案例库
    @ResponseBody
    public Map<String, Object> GetAllexperiment(HttpServletRequest request) throws FileNotFoundException {
        List<resource> resourceList = new ArrayList<>();
        List<SuccessCourse> successCourseList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        List<resource> resources=resourceService.GetAllResource();
        Map<String, Object> map = new HashMap<>();
        System.out.println("11111111111"+resources);
        for(resource resource: resources ){
            if(resource.getResource_experiment()!=null){
                resourceList.add(resource);
                SuccessCourse successCourse = resourceService.selectSuccessCourseById(resource.getSuccess_id());
                successCourseList.add(successCourse);
                Course course = resourceService.selectCourseById(successCourse.getCourse_id());
                courseList.add(course);
                Teacher teacher = resourceService.selectTeacherById(successCourse.getTeacher_id());
                teacherList.add(teacher);
            }
        }
        map.put("resourceList",resourceList);
//        map.put("successCourseList",successCourseList);
        map.put("courseList",courseList);
        map.put("teacherList",teacherList);
        return map;
    }

    @RequestMapping(value = "/GetAlldocument",method = RequestMethod.GET)     //文档
    @ResponseBody
    public Map<String, Object> GetAlldocument(HttpServletRequest request) throws FileNotFoundException {
        List<resource> resourceList = new ArrayList<>();
        List<SuccessCourse> successCourseList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        List<resource> resources=resourceService.GetAllResource();
        Map<String, Object> map = new HashMap<>();
        for(resource resource: resources ){
            if(resource.getResource_document()!=null){
                resourceList.add(resource);
                SuccessCourse successCourse = resourceService.selectSuccessCourseById(resource.getSuccess_id());
                successCourseList.add(successCourse);
                Course course = resourceService.selectCourseById(successCourse.getCourse_id());
                courseList.add(course);
                Teacher teacher = resourceService.selectTeacherById(successCourse.getTeacher_id());
                teacherList.add(teacher);
            }
        }
        map.put("resourceList",resourceList);
//        map.put("successCourseList",successCourseList);
        map.put("courseList",courseList);
        map.put("teacherList",teacherList);
        return map;
    }

    @RequestMapping(value = "/GetAllexperiment_house",method = RequestMethod.GET)     //
    @ResponseBody
    public Map<String, Object> GetAllexperiment_house(HttpServletRequest request) throws FileNotFoundException {
        List<experiment_house> experimentHouseList = new ArrayList<>();
        List<SuccessCourse> successCourseList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        List<experiment_house> experiment_houses=resourceService.GetAllExperiment_house();
        Map<String, Object> map = new HashMap<>();
        for(experiment_house experiment_house: experiment_houses ){
                experimentHouseList.add(experiment_house);
                resource resource = resourceService.selectResourceById(experiment_house.getResource_id());
                SuccessCourse successCourse = resourceService.selectSuccessCourseById(resource.getSuccess_id());
                successCourseList.add(successCourse);
                Course course = resourceService.selectCourseById(successCourse.getCourse_id());
                courseList.add(course);
                Teacher teacher = resourceService.selectTeacherById(successCourse.getTeacher_id());
                teacherList.add(teacher);
        }
        map.put("experimentHouseList",experimentHouseList);
//        map.put("successCourseList",successCourseList);
        map.put("courseList",courseList);
        map.put("teacherList",teacherList);
        return map;
    }

    @RequestMapping(value = "/DeleteTextbook",method = RequestMethod.GET)
    @ResponseBody
    public String DeleteTextbook(Integer resource_id){
        String code="0";
        resource resource = resourceService.selectResourceById(resource_id);
        String downloadFilePath = System.getProperty("user.dir");
        String downloadFilePath1 =downloadFilePath+"\\src\\main\\resources\\ppt\\";
        String downloadFilePath2 = downloadFilePath+"\\src\\main\\resources\\video\\";
        File fileDir = new File(downloadFilePath1);
        File fileDir2 = new File(downloadFilePath2);
        if(resource.getResource_textbook()!=null){
            String fileName= resource.getResource_textbook();
            File file = new File(fileDir+"/"+fileName);
            file.delete();
        }
        else if(resource.getResource_video()!=null){
            String fileName= resource.getResource_video();
            File file = new File(fileDir2+"/"+fileName);
            file.delete();
        }
        else if(resource.getResource_base()!=null){
            String fileName= resource.getResource_base();
            File file = new File(fileDir+"/"+fileName);
            file.delete();
        }
        else if(resource.getResource_experiment()!=null){
            String fileName= resource.getResource_experiment();
            File file = new File(fileDir+"/"+fileName);
            file.delete();
        }
        else if(resource.getResource_document()!=null){
            String fileName= resource.getResource_document();
            File file = new File(fileDir+"/"+fileName);
            file.delete();
        }
        resource.setResource_textbook(null);
        resource.setResource_video(null);
        resource.setResource_base(null);
        resource.setResource_experiment(null);
        resource.setResource_document(null);
        int state=1;
        state= resourceService.DeleteTextbook(resource);
        System.out.println(state);
        if(state==0)
            code="400";
        return code;
    }

    @RequestMapping(value = "/DeleteExperiment_house",method = RequestMethod.GET)
    @ResponseBody
    public String DeleteExperiment_house(Integer experiment_id){
        String code="0";
        int state=1;
        state= resourceService.DeleteExperiment_house(experiment_id);
        System.out.println(state+"!!!!!!!!!!!!!!!!!!!!!");
        if(state==0)
            code="400";
        return code;
    }

    @RequestMapping(value = "/findAllVideo",method = {RequestMethod.POST})
    @ResponseBody
    public String findAllVideo(){
        List<Video> videos=new ArrayList<>();
        List<Video> allVideo= videoService.findAllVideo();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!11");
        System.out.println(allVideo);

//        for(int i=(anInt-1)*5; i<(anInt-1)*5+5 && i<allVideo.size(); i++){
//            videos.add(allVideo.get(i));
//        }
        JSONObject jsonObject = new JSONObject();
//        int r = allVideo.size()%5==0?0:1;
//        jsonObject.put("page",allVideo.size()/5+r);
//        jsonObject.put("curPage",anInt);
        jsonObject.put("data",videos);
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }
}

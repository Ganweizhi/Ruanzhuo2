package com.dgut.CCC_WYM.services;

        import com.dgut.CCC_WYM.javabeans.*;
        import com.dgut.CCC_WYM.mapper.upload;
        import org.apache.ibatis.annotations.Update;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
@Service

public class uploadServices {
    @Autowired
    private  upload Upload ;
    public List<successCourse> getAllSuccessCourse()
    {
        return Upload.getAllSuccessCourse();
    }
    public List<String> getCourse_Id()
    {
        return Upload.getCourse_id();
    }
    public List<course> getCourse()
    {
        return Upload.getCourse();
    }
    public List<teacher> getSuccessCourseTacher(){return Upload.getSuccessCourseTeacher();}
    public List<image_qq> getAllQQImage(){return Upload.getAllQQImage();}
    public List<image_wechat> getAllWechatImage(){return  Upload.getAllWechatImage();}
    public void setQQimage(String qq,String success_id)
    {
        Upload.setQQimage(qq,success_id);
    }
    public void setWechatimage(String wechat,String course_id,String teacher_id)
    {
        Upload.setWechatimage(wechat, course_id, teacher_id);
    }
    public List<success_id> getALLsucessIdForQQ()
    {
        return Upload.getAllSuccess_idForQQ();
    }
    public void delete(String suuccess_id)
    {
        Upload.deleteQQ(suuccess_id);
    }
    public List<beforeQQ> getBeforeQQ()
    {
       return Upload.getBeforQQ();
    }
}

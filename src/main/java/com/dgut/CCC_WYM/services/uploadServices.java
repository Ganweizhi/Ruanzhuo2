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
    public void setWechatimage(String wechat,String success_id)
    {
        Upload.setWechatimage(wechat,success_id);
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
    public void webUpload(String name,String title,String times,String content)
    {
        Upload.insertIntoQuestion(name, title, times, content);
    }
    public List<webTitle> getAllTitle()
    {
        return  Upload.getAllTitle();
    }
    public Webquestion getWebQuestionById(String qid)
    {
        return Upload.getWebQuestionByQid(qid);
    }
    public List<webTitle> getAllNotSovledQuestion()
    {
        return Upload.getAllNotslovedQuestion();
    }
    public void responseQuestion(String question_id,String answer)
    {
        Upload.responesQuestion(question_id, answer);
    }
    public List<beforeWechat> getAllWechatUrl()
    {
        return Upload.getBeforWechat();
    }
    public List<success_id> getAllWechatNotUpload()
    {
        return Upload.getAllSuccess_idForWechat();
    }
    public void deleteWechat(String success_id)
    {
        Upload.deleteWechat(success_id);
    }
    public void changeQQ(String success_id,String success_QQ){
        Upload.updateQQ(success_id, success_QQ);
    }
    public void changeWechat(String success_id,String success_wechat)
    {
        Upload.updateWechat(success_id, success_wechat);
    }
}

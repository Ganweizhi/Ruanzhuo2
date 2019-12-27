package com.dgut.CCC_WYM.services;

        import com.dgut.CCC_WYM.beans.successCourse;
        import com.dgut.CCC_WYM.mapper.upload;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;
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

}

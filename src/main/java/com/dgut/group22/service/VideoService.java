package com.dgut.group22.service;

import com.dgut.group22.dao.IVideoDao;
import com.dgut.group22.javaBean.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private IVideoDao videoDao;

    public List<Video> FindAllCourseName()
    {
        return videoDao.findAllVideo();
    }

    public String FindCourseVideoPath(String course_id)
    {
        return videoDao.FindCourseVideoPath(course_id);
    }

    public List<Video> findAllVideo(){
        return videoDao.findAllVideo();
    }
}

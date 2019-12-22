/**
 * 教学效果服务层
 * @Author wjwwhs
 */
package com.dgut.group33.service;

import com.dgut.group33.javaBean.ExpertComment;
import com.dgut.group33.dao.TeachingEffectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachingEffectService {

    @Autowired
    private TeachingEffectMapper teachingEffectMapper;

    public List<ExpertComment> selectAllComment() {
        return teachingEffectMapper.selectAllComment();
    }

    public List<ExpertComment> selectAllLeaderComment() {
        return teachingEffectMapper.selectAllLeaderComment();
    }

    public List<ExpertComment> selectAllTeacherComment() {
        return teachingEffectMapper.selectAllTeacherComment();
    }

    public List<ExpertComment> selectAllStudentComment() {
        return teachingEffectMapper.selectAllStudentComment();
    }

    public List<ExpertComment> selectAllSocialComment() {
        return teachingEffectMapper.selectAllSocialComment();
    }
}

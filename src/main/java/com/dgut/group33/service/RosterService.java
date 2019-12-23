package com.dgut.group33.service;

import com.dgut.group33.dao.ClassMapper;
import com.dgut.group33.dao.StudentMapper;
import com.dgut.group33.javaBean.Class;
import com.dgut.group33.javaBean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RosterService {
    @Autowired
    ClassMapper classMapper;
    @Autowired
    StudentMapper studentMapper;

    public List<Class> findAllClass() {
        return classMapper.findAllClass();
    }

    public Class findClassById(int class_id) {
        return classMapper.findClassById(class_id);
    }

    public List<Student> findStudentByCid(int class_id) {
        return studentMapper.findStudentByCid(class_id);
    }
}

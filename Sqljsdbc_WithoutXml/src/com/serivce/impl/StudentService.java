package com.serivce.impl;

import com.dao.IStudentDao;
import com.domain.Student;
import com.serivce.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentService implements IStudentService {
    @Resource(name = "studentDao")
    private IStudentDao studentDao;

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}

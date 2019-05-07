package com.service.impl;

import com.dao.IStudentDao;
import com.domain.Students;
import com.service.IStudentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("studentsService")
public class StudentsServiceImpl implements IStudentsService {

    @Resource(name = "studentDao")
    private IStudentDao studentDao;

    @Override
    public List<Students> findAllStudents() {
        return studentDao.findAllStudents();
    }

    @Override
    public void saveStudent(Students stu) {
        studentDao.saveStudent(stu);
    }

    @Override
    public void updateStudent(Students stu) {
        studentDao.updateStudent(stu);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public Students findStudentById(int id) {
        return studentDao.findStudentById(id);
    }
}

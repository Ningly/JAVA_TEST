package service.impl;

import dao.IStudentDao;
import domain.Students;
import service.IStudentsService;

import java.util.List;

public class StudentsServiceImpl implements IStudentsService {

    private IStudentDao studentDao;
    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

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

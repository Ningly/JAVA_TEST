package service;

import domain.Students;

import java.util.List;

/*
* 业务层接口
* */
public interface IStudentsService {

    List<Students> findAllStudents();
    void saveStudent(Students stu);
    void updateStudent(Students stu);
    void deleteStudent(int id);
    Students findStudentById(int id);
}

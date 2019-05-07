package com.dao;

import com.domain.Students;

import java.util.List;

/*
* 持久层接口
* */
public interface IStudentDao {
    List<Students> findAllStudents();
    void saveStudent(Students stu);
    void updateStudent(Students stu);
    void deleteStudent(int id);
    Students findStudentById(int id);
}

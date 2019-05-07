package com.dao;

import com.domain.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> findAll();
}

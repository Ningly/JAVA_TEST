package com.serivce.impl;

import com.config.SpringConfiguration;
import com.domain.Student;
import com.serivce.IStudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class StudentServiceTest {

    @Test
    public void findAll() {
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IStudentService ss=(IStudentService)ac.getBean("studentService");
        List<Student> list=ss.findAll();
        for (Student stu : list) {
            System.out.println(stu);
        }
    }
}




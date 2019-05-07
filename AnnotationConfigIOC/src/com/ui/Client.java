package com.ui;

import com.config.SpringConfiguration;
import com.domain.Students;
import com.service.IStudentsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class Client {
    @SuppressWarnings("all")
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IStudentsService cs = (IStudentsService) ac.getBean("studentsService");
        List<Students> list=cs.findAllStudents();
        for (Students stu :
                list) {
            System.out.println(stu);
        }
    }
}

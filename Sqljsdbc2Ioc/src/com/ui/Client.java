package com.ui;

import com.service.IStudentsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Client {
    @SuppressWarnings("all")
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IStudentsService cs= (IStudentsService) ac.getBean("studentsService");

        System.out.println(cs);
    }
}

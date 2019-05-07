package com;

import com.doman.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        /*DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ds.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=Tutoral");
        ds.setUsername("sa");
        ds.setPassword("Sa123456");
        JdbcTemplate dt=new JdbcTemplate(ds);*/

        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt=(JdbcTemplate)ac.getBean("jdbcTemplate"); 
        List<Student> list = jt.query("select * from Students where id>?", new BeanPropertyRowMapper<Student>(Student.class),1);
        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }
}

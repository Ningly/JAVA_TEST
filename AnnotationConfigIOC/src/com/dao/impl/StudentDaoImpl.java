package com.dao.impl;

import com.dao.IStudentDao;
import com.domain.Students;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl implements IStudentDao {

    ////空参，自动到classpath目录下面加载“c3p0-config.xml”配置文件---配置文件的存储位置和名称必须是这样，且使用“默认配置”
//    private QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
    ////加载“c3p0-config.xml”文件中定义的“demo”这个配置元素
//    private QueryRunner runner=new QueryRunner(new ComboPooledDataSource("demo"));

    @Resource(name = "runner")
    private QueryRunner runner;

    @Override
    public List<Students> findAllStudents() {
        try {
            return runner.query("select * from students", new BeanListHandler<Students>(Students.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void saveStudent(Students stu) {
        try {
            runner.update("insert into students (FirstName,LastName,Gender) values(?,?,?)",stu.getFirstName(),stu.getLastName(),stu.getGender());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void updateStudent(Students stu) {
        try {
            runner.update("update students set FirstName=?,LastName=?,Gender=? where id=?",
                    stu.getFirstName(),stu.getLastName(),stu.getGender());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            runner.update("delete from students where id=?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Students findStudentById(int id) {
        try {
            return runner.query("select * from students where id=?", new BeanHandler<Students>(Students.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

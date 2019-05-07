package com.dao.impl;

import com.dao.IStudentDao;
import com.domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository("studentDao")
public class StudentDao implements IStudentDao {
    @Resource(name = "runner")
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Student> findAll() {
        try {
            return runner.query("select * from students", new BeanListHandler<Student>(Student.class));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

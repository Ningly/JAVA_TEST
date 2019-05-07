package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class JdbcConfig {

    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;
    
    
    @Bean("runner")
    public QueryRunner getQueryRunner(@Qualifier("dataSource1") DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    
    @Bean("dataSource1")
    public ComboPooledDataSource getComboPooledDataSource(){
        ComboPooledDataSource ds=new ComboPooledDataSource();
        try {
            ds.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl(jdbcUrl);
        ds.setUser(user);
        ds.setPassword(password);
        return ds;
    }
    
    @Bean("dataSource2")
    public ComboPooledDataSource getComboPooledDataSource1(){
        ComboPooledDataSource ds=new ComboPooledDataSource();
        try {
            ds.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl(jdbcUrl);
        ds.setUser(user);
        ds.setPassword(password);
        return ds;
    }
}

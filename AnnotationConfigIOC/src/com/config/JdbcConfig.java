package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
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


    @Bean("runner")  //他是把方法的返回值存入到spring容器中。该注解有一个属性 name ：用于指定bean的id;;当不指定时他有默认值，默认值是方法的名称
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource ds=new ComboPooledDataSource();
        try {
            ds.setDriverClass(driverClass);
            ds.setJdbcUrl(jdbcUrl);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }
}

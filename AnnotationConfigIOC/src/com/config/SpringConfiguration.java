package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/*
 *一个spring的配置类，它的作用就相当于bean.xml
 * */
//@Configuration //它就是把当前类看成是spring的配置类
@ComponentScan("com")
@Import({JdbcConfig.class}) //导入其它配置类
@PropertySource("classpath:com/config/jdbcConfig.properties")
public class SpringConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

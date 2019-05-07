package com.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration  //把当前类看成是spring的配置类
@ComponentScan("com")  //扫描com包
@Import({JdbcConfig.class})  //导入其它配置类
@PropertySource("classpath:/com/config/jdbcConfig.properties")
@EnableAspectJAutoProxy

public class SpringConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}




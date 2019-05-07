package com.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.ICustomerService;

/*
* spring 入门
* */
public class Client {
    /*
    * ClassPathXmlApplicationContext：只能加载类路径下的配置文件
    * FileSystemXmlApplicationContext：可以加载磁盘任意路径下的配置文件
    *
    * Bean创建的两种规则：
    *  BeanFactory:
    *       提供的是一种延迟加载思想来创建bean对象。bean对象什么时候用什么时候创建
    *  ApplicationContext：
    *       提供的是一种立即加载思想来创建bean对象。只要一解析完配置文件，就立马来创建对象
    * */
    @SuppressWarnings("all")
    public static void main(String[] args){
        //1. 获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        ICustomerService cs= (ICustomerService) ac.getBean("customerService");
        ICustomerService cs1= (ICustomerService) ac.getBean("customerService");
        System.out.println(cs==cs1);
        cs.saveCustomer();
    }
}

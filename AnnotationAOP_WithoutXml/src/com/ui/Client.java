package com.ui;

import com.config.SpringConfiguration;
import com.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac =new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ICustomerService cs=(ICustomerService)ac.getBean("customerService");
        
        cs.saveCustomer();
        /*cs.updateCustomer(9);
        cs.removeCustomer();*/
    }
}

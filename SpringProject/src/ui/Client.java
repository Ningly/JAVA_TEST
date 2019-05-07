package ui;

import factory.BeanFactory;
import service.ICustomerService;

/*
* 模拟一个表现层，用于调用业务层
* */
public class Client {
    public static void main(String[] args){
//        ICustomerService customerService=new CustomerServiceImpl();

        ICustomerService customerService= (ICustomerService) BeanFactory.getObj("CUSTOMERSERVICE");
        customerService.saveCustomer();
    }
}

package test;

import annotations.MyTest;
import service.ICustomerService;
import service.impl.CustomerServiceImpl;

/*
 * 客户业务层测试类
 * */


public class CustomerTest {
    @MyTest
    public void saveCustomer() {
        ICustomerService cs=new CustomerServiceImpl();
        cs.saveCustomer();
    }
}

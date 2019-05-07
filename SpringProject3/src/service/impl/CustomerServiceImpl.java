package service.impl;

import service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

    public CustomerServiceImpl() {
        System.out.println("bean 对象创建了");
    }

    public void init(){
        System.out.println("对象初始化");
    }
    public void destory(){
        System.out.println("对象消亡");
    }
    @Override
    public void saveCustomer() {
        System.out.println("业务层调用了持久层");
    }
}

package service.impl;

import service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用了持久层");
    }
}

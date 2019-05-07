package service.impl;

import dao.ICustomerDao;
import service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

    public CustomerServiceImpl(ICustomerDao dao) {
        this.dao = dao;
    }

    private ICustomerDao dao=null;

    public CustomerServiceImpl() {
        System.out.println("bean 对象创建了");
    }

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用了持久层");
        dao.saveCustomer();
    }
}

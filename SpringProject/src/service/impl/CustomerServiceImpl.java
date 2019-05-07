package service.impl;

import dao.ICustomerDao;
import dao.impl.CustomerDaoImpl;
import factory.BeanFactory;
import service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {
//    private ICustomerDao customerDao=new CustomerDaoImpl();

    private ICustomerDao customerDao= (ICustomerDao) BeanFactory.getObj("CUSTOMERDAO");

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用了持久层");
        customerDao.saveCustomer();
    }
}

package dao.impl;

import dao.ICustomerDao;

public class CustomerDaoImpl implements ICustomerDao {

    @Override
    public void saveCustomer() {
        System.out.println("持久层保存了客户");
    }
}

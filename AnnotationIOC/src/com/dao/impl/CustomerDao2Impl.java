package com.dao.impl;

import com.dao.ICustomerDao;
import org.springframework.stereotype.Repository;

@Repository("customerDao2")
public class CustomerDao2Impl implements ICustomerDao {

    @Override
    public void saveCustomer() {
        System.out.println("持久层保存了客户");
    }
}

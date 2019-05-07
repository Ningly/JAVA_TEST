package com.service.iml;

import com.service.ICustomerService;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService implements ICustomerService {
    @Override
    public void saveCustomer() {
        System.out.println("saveCustomer");
    }

    @Override
    public void updateCustomer(int i) {
        System.out.println("updateCustomer");
    }

    @Override
    public int removeCustomer() {
        System.out.println("removeCustomer");
        return 0;
    }
}

package com.Service.Imp;

import com.Service.ICustomerService;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService implements ICustomerService {
    
    @Override
    public void saveCustomer() {
        System.out.println("saveCustomer");
    }

    @Override
    public void updateCustomer(int i) {
        System.out.println("saveCustomer");
    }

    @Override
    public int removeCustomer() {
        System.out.println("removeCustomer");
        return 0;
    }
}

package service.impl;

import service.ICustomerService;

import java.util.Date;

public class CustomerServiceImpl implements ICustomerService {

    private String driver;
    private Integer port;
    private Date today;

    public CustomerServiceImpl(String driver, Integer port, Date today) {
        this.driver = driver;
        this.port = port;
        this.today = today;
    }

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用了持久层:"+driver+":"+port+":"+today);
    }
}

package service.impl;

import service.ICustomerService;

import java.util.Date;

public class CustomerServiceImpl2 implements ICustomerService {

    private String driver;
    private Integer port;
    private Date today;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用了持久层:"+driver+":"+port+":"+today);
    }
}

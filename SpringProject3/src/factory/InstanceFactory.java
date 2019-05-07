package factory;

import service.ICustomerService;
import service.impl.CustomerServiceImpl;

/*
* 模拟一个实例工厂
* */
public class InstanceFactory {
    public ICustomerService getCustomerService(){
        return new CustomerServiceImpl();
    }
}

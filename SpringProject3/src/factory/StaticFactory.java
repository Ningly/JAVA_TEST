package factory;

import service.ICustomerService;
import service.impl.CustomerServiceImpl;

/*
* 模拟一个静态工厂
* */
public class StaticFactory {
    public static ICustomerService getCustomerService(){
        return new CustomerServiceImpl();
    }
}

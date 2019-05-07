package com.ui;

import com.Service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ICustomerService cs = (ICustomerService) ac.getBean("customerService");
        /*ICustomerService proxyCs=(ICustomerService) Proxy.newProxyInstance(cs.getClass().getClassLoader(), cs.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                new Logger().printLog();
                method.invoke(cs, args);
                return null;
            }
        }) ;
        proxyCs.saveCustomer();*/
        cs.saveCustomer();
        /*cs.updateCustomer(8);
        cs.removeCustomer();*/
    }
}

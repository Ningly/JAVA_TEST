package factory;

import service.IStudentsService;
import service.impl.StudentsServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    public static IStudentsService getNewInstance() {
        final IStudentsService cs = new StudentsServiceImpl();
        IStudentsService myProxy = (IStudentsService) Proxy.newProxyInstance(cs.getClass().getClassLoader(), cs.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = new Object();
                try {
                    // 开启事务

                    // 执行操作
                    obj = method.invoke(cs, args);
                    // 提交事务

                    // 返回结果
                } catch (Exception e) {

                } finally {

                }
                return obj;
            }
        });
        return myProxy;
    }
}

package ui;

import annotations.MyTest;
import test.CustomerTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
* 读取测试类注解
* */
public class Client {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //1.得到测试类的字节码
        Class clazz= CustomerTest.class;
        Method[] methods=clazz.getMethods();
        for (Method method :
                methods) {
            boolean b= method.isAnnotationPresent(MyTest.class);
//            System.out.println(b);
            if(b){
                method.invoke(clazz.newInstance(), null);
            }
        }

    }
}

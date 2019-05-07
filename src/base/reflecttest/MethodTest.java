package base.reflecttest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        getMethodDemo();
    }

    private static void getMethodDemo() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 获取Class对象
        String str = "base.reflecttest.bean.Person";
        Class class1=Class.forName(str);
        // 获取Person对象
        Object obj=class1.newInstance();

        // 获取带参的构造函数
        Constructor constructor=class1.getConstructor(int.class,String.class);
        Object obj1=constructor.newInstance(22,"nihao");

        // 获取方法
        Method method=class1.getMethod("show");
        method.invoke(obj, null);


        Method method1=class1.getDeclaredMethod("paramMethod",String.class,int.class);
        method1.setAccessible(true);
        method1.invoke(obj, "aa",11);

        Method method2=class1.getMethod("staticMethod");
        method2.invoke(obj, null);
    }
}

package base.reflecttest;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorTest {
    public static void main(String[] args) throws ClassNotFoundException {

    }

    public static void createNewObject() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 早期 new(),现根据被new的类的名称找寻该类的字节码，并加载到内存，
        // 并创建该字节码文件对象，并接着创建该字节文件的对应的Person对象。
        base.reflecttest.bean.Person person = new base.reflecttest.bean.Person();

        // 现在
        String str = "base.reflecttest.bean.Person";
        // 找寻该名称类文件，并加载进内存，并产生class对象
        Class class1 = Class.forName(str);
        // 1.
        Object object = class1.newInstance();


        // 2.获取指定类对象的构造函数对象
        Constructor constructor = class1.getConstructor(int.class, String.class);
        // 通过该构造器对象的newInstance方法进行对象初始化
        Object object1 = constructor.newInstance(20, "haha");
    }
}

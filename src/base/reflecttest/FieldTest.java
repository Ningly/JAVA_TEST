package base.reflecttest;

import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        getFiledDemo();
    }

    private static void getFiledDemo() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        String str = "base.reflecttest.bean.Person";
        // 找寻该名称类文件，并加载进内存，并产生class对象
        Class class1 = Class.forName(str);
        Object obj=class1.newInstance();
        Field field = class1.getDeclaredField("name");

        // 对私有字段的访问取消权限检查
        field.setAccessible(true);

        field.set(obj, "fasdfasf");
        Object name = field.get(obj);
        System.out.println(name);

    }
}

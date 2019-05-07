package base.reflecttest;

import base.reflecttest.bean.Person;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        getClassObject_1();
        getClassObject_2();
        getClassObject_3();
    }

    /*
    * 获取字节码对象方式：
    * 1. object类中的getClass()
    *  想要用到这种方式，必须要明确具体的类，并创建对象
    * */
    public static void getClassObject_1(){
        Person p1=new Person();
        Class class1=p1.getClass();
        Person p2=new Person();
        Class class2=p1.getClass();
        System.out.println(class1==class2);

    }

    /*
     * 获取字节码对象方式：
     * 2. 任何数据类型都具备一个静态的属性.class，来获取其对应的class对象
     *   相对简单，但是还是哟啊明确用到类中的静态成员
     * */
    public static void getClassObject_2(){
        Class class1=Person.class;
        Class class2=Person.class;

        System.out.println(class1==class2);

    }


    /*
     * 获取字节码对象方式：
     * 2. 只要通过给定的类的字符串名称就可以获取到该类
     *   用Class类中的 forName()
     *   这种方式只要有名称即可，更为方便，扩展性更强
     * */
    public static void getClassObject_3() throws ClassNotFoundException {
        String className="base.reflecttest.bean.Person";
        Class class1=Class.forName(className);
        System.out.println(class1);

    }
}

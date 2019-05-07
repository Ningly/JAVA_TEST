package base.reflecttest.bean;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println(" Person(int age, String name) running");
    }

    public Person() {
        System.out.println(" Person() running");
    }

    public void show(){
        System.out.println(" show() running");
    }
    private void method(){
        System.out.println(" method() running");
    }

    private void paramMethod(String str,int num){
        System.out.println(" paramMethod() running..."+str+":"+num);
    }
    public static void staticMethod(){
        System.out.println(" staticMethod() running...");
    }
}

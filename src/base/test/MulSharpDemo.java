package base.test;

public class MulSharpDemo {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.eat();  //子类eat
        a.method(); //父类static method
        System.out.println(a.num);  //3
    }
}

abstract class Animal {
    int num=3;
    void eat() {
        System.out.println("父类eat");
    }
    static void method() {
        System.out.println("父类static method");
    }
}

class Cat extends Animal {
    int num=1;
    void eat() {
        System.out.println("子类eat");
    }
    static void method() {
        System.out.println("子类static method");
    }
}

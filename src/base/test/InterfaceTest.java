package base.test;

public class InterfaceTest {
    public static void main(String[] args) {

    }
}

interface Demo {
    int NUM = 4;

    void show();
}

interface Demo1 {
    public static final int NUM = 4;

    public void show();
}


interface CC {
    public abstract void show();
}

interface MM {
    public abstract void method();
}
interface QQ extends CC,MM{
    public abstract void function();
}




package base.threadTest;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadDemo demo=new ThreadDemo("子线程");
        demo.start();
        for (int i=0;i<9;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        
        
    }
}

class ThreadDemo extends Thread{

    public ThreadDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<9;i++){
            System.out.println(this.getName()+":"+i);
        }
    }
}

class ThreaDemo1 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<9;i++){
            System.out.println(i);
        }
    }
}

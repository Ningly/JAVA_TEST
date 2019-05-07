package base.threadTest;

public class DeadLockTest {
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Thread t1 = new Thread(deadLock);
        t1.start();

        Thread t2 = new Thread(deadLock);
        t2.start();
    }
}

class DeadLock implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ":this");
            synchronized (DeadLock.class) {
                System.out.println(Thread.currentThread().getName() + ":DeadLock.class");
            }
        }
        synchronized (DeadLock.class) {
            System.out.println(Thread.currentThread().getName() + ":DeadLock.class");
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + ":this");
            }
        }
    }
}

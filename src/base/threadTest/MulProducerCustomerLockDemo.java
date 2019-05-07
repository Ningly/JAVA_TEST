package base.threadTest;

import java.util.concurrent.locks.*;

//*
// 共享资源
// 多生产者
// 多消费者
// */
public class MulProducerCustomerLockDemo {
    public static void main(String[] args) {
        Resource1 r = new Resource1();
        Producer1 producer = new Producer1(r);
        Customer1 customer = new Customer1(r);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(customer);
        Thread t4 = new Thread(customer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Resource1 {
    private String name;
    private int count;
    private boolean flag;

    Lock lock = new ReentrantLock();
    Condition producerCon = lock.newCondition();
    Condition customerCon = lock.newCondition();

    public void set(String name) {
        lock.lock();
        while (true) {
            while (flag) {
                try {
                    producerCon.await();
                } catch (InterruptedException e) {
                }
            }
            this.name = name + ++count;
            flag = true;
            System.out.println("生产了：" + this.name);
            customerCon.signal();
        }
    }

    public void out() {
        lock.lock();
        try {
            while (true) {
                while (flag) {
                    System.out.println("消费了-----------------：" + this.name);
                    flag = false;
                    producerCon.signal();
                }
                try {
                    customerCon.await();
                } catch (InterruptedException e) {
                }
            }

        } finally {
            lock.unlock();
        }
    }
}

class Producer1 implements Runnable {
    Resource1 r;

    public Producer1(Resource1 r) {
        this.r = r;
    }

    @Override
    public void run() {
//        while (true)
        r.set("北京烤鸭");
    }
}

class Customer1 implements Runnable {
    Resource1 r;

    public Customer1(Resource1 r) {
        this.r = r;
    }

    @Override
    public void run() {
//        while (true)
        r.out();
    }
}





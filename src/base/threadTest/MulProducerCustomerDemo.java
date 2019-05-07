package base.threadTest;

//*
// 共享资源
// 多生产者
// 多消费者
// */
public class MulProducerCustomerDemo {
    public static void main(String[] args) {
        Resource r = new Resource();
        Producer producer = new Producer(r);
        Customer customer = new Customer(r);
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

class Resource {
    private String name;
    private int count;
    private boolean flag;

    public synchronized void set(String name) {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.name = name + ++count;
        flag = true;
        System.out.println("生产了：" + this.name);
        this.notifyAll();
    }

    public synchronized void out() {
        while (flag) {
            System.out.println("消费了-----------------：" + this.name);
            flag = false;
            this.notifyAll();
        }
        try {
            this.wait();
        } catch (InterruptedException e) {
        }
    }
}

class Producer implements Runnable {
    Resource r;

    public Producer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true)
            r.set("北京烤鸭");
    }
}

class Customer implements Runnable {
    Resource r;

    public Customer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true)
            r.out();
    }
}





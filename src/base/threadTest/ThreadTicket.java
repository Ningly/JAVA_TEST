package base.threadTest;

public class ThreadTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        t1.start();
        Thread t2 = new Thread(ticket);
        t2.start();
        Thread t3 = new Thread(ticket);
        t3.start();
        Thread t4 = new Thread(ticket);
        t4.start();
    }
}
class Ticket implements Runnable {
    public int num = 100;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                try {
                    Thread.sleep(10);
                    if (num > 0) {
                        num--;
                        System.out.println("剩余票数：" + num);
                    }
                    else {
                        System.out.println("没票了");
                        break;
                    }
                }
                catch (InterruptedException e){
                }
            }
        }
    }
}

class Ticket2 extends Thread {
    public static int num = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj) {
            if (num > 0) {
                num--;
                System.out.println("剩余票数：" + num);
            } else {
                System.out.println("没票了");
            }
        }
    }
}
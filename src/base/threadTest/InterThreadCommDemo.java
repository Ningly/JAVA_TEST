package base.threadTest;

public class InterThreadCommDemo {
    public static void main(String[] args) {
        Resouse resouse = new Resouse();
        Input input = new Input(resouse);
        Output output = new Output(resouse);
        Thread inputT = new Thread(input);
        Thread outputT = new Thread(output);
        inputT.start();
        outputT.start();
    }
}

class Resouse {
    String name;
    String sex;
    Boolean flag = false;
}


class Input implements Runnable {
    Resouse resouse = null;

    public Input(Resouse resouse) {
        this.resouse = resouse;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (resouse) { //resouse也称监视器
                //此语句用于验证notify是唤醒任意一个线程，非特定线程
                System.out.println("Input");
                if (resouse.flag)
                    try {
                        //wait()在操作指定监视器上的线程
                        //wait()方法让当前线程等待，无法执行下面的语句
                        resouse.wait();
                    } catch (InterruptedException e) {

                    }
                if (x == 0) {
                    resouse.name = "a";
                    resouse.sex = "a";

                } else {
                    resouse.name = "b";
                    resouse.sex = "b";
                }
                x = ++x % 2;
                resouse.flag = true;
                resouse.notify();
            }
        }

    }
}

class Output implements Runnable {
    Resouse resouse = null;

    public Output(Resouse resouse) {
        this.resouse = resouse;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (resouse) {
                //此语句用于验证notify是唤醒任意一个线程，非特定线程
                System.out.println("Output");
                if (!resouse.flag)
                    try {
                        resouse.wait();
                    } catch (InterruptedException e) {

                    }
                else {
                    System.out.println(resouse.name);
                    resouse.flag = false;
                    resouse.notify();
                }
            }
        }

    }
}
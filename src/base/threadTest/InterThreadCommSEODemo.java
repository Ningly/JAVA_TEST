package base.threadTest;

public class InterThreadCommSEODemo {
    public static void main(String[] args) {
        ResouseSEO resouse = new ResouseSEO();
        InputSEO input = new InputSEO(resouse);
        OutputSEO output = new OutputSEO(resouse);
        Thread inputT = new Thread(input);
        Thread outputT = new Thread(output);
        inputT.start();
        outputT.start();
    }
}

class ResouseSEO {
    private String name;
    private String sex;
    private Boolean flag=false;

    public synchronized void print() {
        if (flag){
            System.out.println("name=" + name + "  sex=" + sex);
            this.notify();
        }

        flag=false;
        try {
            this.wait();
        } catch (InterruptedException e) {
        }
    }
    public synchronized void set(String name, String sex) {
        if (flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        this.name = name;
        this.sex = sex;
        flag=true;
        this.notify();
    }
}


class InputSEO implements Runnable {
    ResouseSEO resouse = null;

    public InputSEO(ResouseSEO resouse) {
        this.resouse = resouse;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            if(x==0)
                resouse.set("1","1--------------------------------------");
            else
                resouse.set("2","2");
            x=++x%2;
        }

    }
}

class OutputSEO implements Runnable {
    ResouseSEO resouse = null;

    public OutputSEO(ResouseSEO resouse) {
        this.resouse = resouse;
    }

    @Override
    public void run() {
        while (true) {
            resouse.print();
        }

    }
}
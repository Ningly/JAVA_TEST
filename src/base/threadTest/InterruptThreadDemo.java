package base.threadTest;

public class InterruptThreadDemo {
    public static void main(String[] args){
        InterruptTask task=new InterruptTask();
        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        t1.start();
        t1.setDaemon(true);
        t2.start();
        int i=0;
        for (;;){
            if(++i==500000){
                task.setFlag();
                t1.interrupt();
                t2.interrupt();
                System.out.println("main over");
                break;
            }
        }
    }
}

class InterruptTask implements Runnable{
    private boolean flag=true;
    @Override
    public synchronized void run() {
        while (flag){
            try {
                wait();
            }catch (InterruptedException e)
            {
                System.out.println(Thread.currentThread().getName()+":"+e.getMessage());
                flag=false;
            }
            System.out.println(Thread.currentThread().getName()+"------------");
        }
    }
    public void setFlag(){
        flag=false;
    }
}

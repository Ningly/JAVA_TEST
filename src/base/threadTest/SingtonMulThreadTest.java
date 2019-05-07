package base.threadTest;

public class SingtonMulThreadTest {
    public static void main(String[] args) {

    }
}

//懒汉式=》延时加载
class SingTon {
    private static SingTon instance = null;

    private SingTon() {
    }

    public static SingTon getInstance() {
        //此判断是为了解决效率问题【程序如果直接执行synchronized语句，则会增加消耗】
        if (instance == null) {
            synchronized (SingTon.class) {  // 加锁是为了解决同步问题
                if (instance == null)
                    instance = new SingTon();
            }
        }
        return instance;
    }
}

//饿汉式
class Sington2{
    private static final Sington2 instance=new Sington2();
    private Sington2(){}
    public static Sington2 getInstance(){
        return instance;
    }
}

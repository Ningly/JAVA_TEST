package base.test;

public class ForDemo {
    public static void main(String[] args){
        a:for (int i = 0; i < 3; i++) {
            b:for (int y = 0; y < 3; y++) {
                System.out.println("x="+i);
                break a;
            }
        }
    }
}

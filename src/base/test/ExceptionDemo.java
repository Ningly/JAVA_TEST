package base.test;

public class ExceptionDemo {
    public static void main(String[] args){
        int[] arr=new int[3];
        new Demoa().method(arr);
    }
}

class Demoa{
    public void method(int[] arr){
        System.out.println(arr[3]);
    }
}
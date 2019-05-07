package base.apis.stringDemos;

import java.util.ArrayList;

public class Wrapper {
    public static void main(String[] args) {
        Integer i=12;
        i=i+5;
        System.out.println(i.intValue());




        Integer a=new Integer(128);
        Integer b=new Integer(128);
        System.out.println(a==b);   //true
        System.out.println(a.equals(b));   //true

        Integer x=127;
        Integer y=127;
        System.out.println(x==y); //true
        System.out.println(x.equals(y));  //true



        Integer x1=128;
        Integer y1=128;
        System.out.println(x1==y1);  //false
        System.out.println(x1.equals(y1));  //true




        //StringBuilder






    }
}

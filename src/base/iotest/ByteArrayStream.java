package base.iotest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStream {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        ByteArrayInputStream bais=new ByteArrayInputStream("abc".getBytes());
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        int len=0;
        while ((len=bais.read())!=-1){
            baos.write(len);
        }
        System.out.println(baos.toString());
    }
}

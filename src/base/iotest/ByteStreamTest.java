package base.iotest;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("d:/a.txt");
        String str="aaaaaa";
        byte[] bytes=str.getBytes();
        fos.write(bytes);
        fos.close();


        FileInputStream fis=new FileInputStream("d:/a.txt");
        byte[] buff=new byte[1024];
        int len=0;
        while ((len=fis.read(buff))!=-1)
            System.out.println(new String(buff,0,len));
        fis.close();

        //available()慎用，小文件可以用，大文件不要用
        /*byte[] buff=new byte[fis.available()];
        fis.read(buff);
        System.out.println(new String(buff));*/
    }
}

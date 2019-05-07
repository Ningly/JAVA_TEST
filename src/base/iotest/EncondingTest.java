package base.iotest;

import java.io.UnsupportedEncodingException;

public class EncondingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="你好";
        byte[] bytes=str.getBytes("gbk");
        String str1=new String(bytes,"ISO-8859-1");
        byte[] bytes1=str1.getBytes("ISO-8859-1");
        String str2=new String(bytes1,"gbk");
        System.out.println(str1);
        System.out.println(str2);

    }
}

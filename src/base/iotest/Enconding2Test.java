package base.iotest;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Enconding2Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="ad你好";
        byte[] bytes=str.getBytes("gbk");
        for (int i = 0; i < bytes.length; ) {
            ++i;
            System.out.println(i+"个字节："+ new String(cutStringByBytes(bytes,i),"gbk"));
        }
    }

    private static byte[] cutStringByBytes(byte[] bytes, int len) {
        int count=0;
        for (int i = 0; i < len; i++) {
            if(bytes[i]<0)
                count++;
            else
                continue;
        }
        count=count%2;
        byte[] bytes1 = Arrays.copyOf(bytes, len-count);
        return bytes1;
    }
}

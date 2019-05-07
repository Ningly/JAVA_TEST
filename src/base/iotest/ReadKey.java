package base.iotest;

import java.io.IOException;
import java.io.InputStream;

public class ReadKey {
    public static void main(String[] args) throws IOException {
        /*InputStream is=System.in;
        int ch=is.read();
        System.out.println(ch);*/


        InputStream is=System.in;
        int len=0;
        StringBuilder sb=new StringBuilder();
        while ((len=is.read())!=-1){
            if(len=='\r')
                continue;
            if(len=='\n'){
                if(sb.toString().equals("over")){
                    break;
                }
                System.out.println(sb.toString());
                sb.delete(0, sb.length());
            }
            else {
                sb.append((char)len);
            }
        }
        System.out.println(sb.toString());
    }
}

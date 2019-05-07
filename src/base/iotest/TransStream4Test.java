package base.iotest;

import java.io.*;
import java.nio.charset.CharsetEncoder;

public class TransStream4Test {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/a.txt"),"UTF-8"));
        bw.write("abc你好");
        bw.flush();
        bw.close();


//        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("d:/a.txt"),"UTF-8"));
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("d:/a.txt"),"GBK"));
        System.out.println(br.readLine());
        br.close();

    }
}

package base.iotest;

import java.io.*;

public class TransStreamTest {
    public static void main(String[] args) throws IOException {

        InputStream is = System.in;
        //流转字符
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);


        OutputStream os=System.out;
        OutputStreamWriter osw=new OutputStreamWriter(os);
        BufferedWriter bw=new BufferedWriter(osw);
        String len;
        while ((len=br.readLine())!=null){
            if(len.equals("over")){
                break;
            }
            bw.write(len);
            bw.newLine();
            bw.flush();
        }
        br.close();
        isr.close();
        bw.close();
        osw.close();
    }
}

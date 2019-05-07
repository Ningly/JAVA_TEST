package base.iotest;

import java.io.*;

public class KeyToConsoleTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String len=null;
        while ((len=br.readLine())!=null){
            if(len.equals("over"))
                break;
            bw.write(len);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
}

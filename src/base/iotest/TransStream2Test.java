package base.iotest;

import java.io.*;

public class TransStream2Test {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String len;
        while ((len=br.readLine())!=null){
            if(len.equals("over")){
                break;
            }
            bw.write(len);
            bw.newLine();
            bw.flush();
        }
    }
}

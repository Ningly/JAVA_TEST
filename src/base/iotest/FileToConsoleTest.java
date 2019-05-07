package base.iotest;

import java.io.*;

public class FileToConsoleTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("d:/a.txt"));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String len=null;
        while ((len=br.readLine())!=null){
            bw.write(len);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
}

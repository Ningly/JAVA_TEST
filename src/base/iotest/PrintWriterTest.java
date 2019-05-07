package base.iotest;

import java.io.*;

public class PrintWriterTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(new FileOutputStream("d:/a.txt"),true);

        String line=null;
        while ((line=br.readLine())!=null){
            if("over".equals(line)){
                break;
            }
            pw.println(line);
        }
        br.close();
        pw.close();
    }
}

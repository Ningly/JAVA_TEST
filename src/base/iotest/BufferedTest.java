package base.iotest;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("d:/a.txt");
        FileWriter fw=new FileWriter("d:/b.txt");
        BufferedReader br=new BufferedReader(fr);
        BufferedWriter bfw=new BufferedWriter(fw);

        /*int len=0;
        while ((len=br.read())!=-1){
            bfw.write(len);
        }*/

        /*char[] chars=new char[1024];
        int len=0;
        while ((len= br.read(chars))!=-1){
            bfw.write(chars, 0, len);
        }*/

        String line=null;
        while((line = br.readLine())!=null){
            bfw.write(line);
            bfw.newLine();
        }

        bfw.close();
        br.close();
    }
}

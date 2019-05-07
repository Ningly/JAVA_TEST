package base.iotest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("d:/a.txt");
        /*int res = 0;
        while ((res = fr.read()) > 0) {
            System.out.println((char) res);
        }
        fr.close();*/


        FileWriter fw=new FileWriter("d:/b.txt");
        char[] chars=new char[1024];
        int len=0;
        while ((len =fr.read(chars)) >0){
            fw.write(chars,0,len);
            System.out.println(new String(chars,0,len));
        }
        fw.close();



    }
}



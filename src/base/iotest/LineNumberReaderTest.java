package base.iotest;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("d:/a.txt");
        LineNumberReader lnr=new LineNumberReader(fr);
        String line=null;
//        lnr.setLineNumber(3);
        while ((line=lnr.readLine())!=null){
            System.out.println(lnr.getLineNumber()+":"+line);
        }
        lnr.close();
    }
}

package base.iotest;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamTest {
    public static void main(String[] args) throws IOException {
        /*Vector<InputStream> vector=new Vector<>();
        vector.add(new FileInputStream("d:/1.txt"));
        vector.add(new FileInputStream("d:/2.txt"));
        vector.add(new FileInputStream("d:/3.txt"));
        Enumeration<InputStream> enumeration=vector.elements();*/


        ArrayList<InputStream> list=new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            list.add(new FileInputStream("d:/"+i+".txt"));
        }
        Enumeration<InputStream> enumeration= Collections.enumeration(list);

        SequenceInputStream sis=new SequenceInputStream(enumeration);

        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("d:/4.txt"));

        String newLine="\r\n";

        byte[] buffer=new byte[1024];
        int len=0;
        while ((len=sis.read(buffer))!=-1){
            bos.write(buffer, 0, len);
            bos.write(newLine.getBytes());
        }
        bos.close();
        sis.close();
    }
}

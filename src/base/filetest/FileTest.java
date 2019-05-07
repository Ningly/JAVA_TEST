package base.filetest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file=new File("b.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        System.out.println(file.getAbsolutePath());

        Date date=new Date(154654658980980L);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        System.out.println(dateStr);



        File dir=new File("a/b/c/d/e");
        dir.mkdirs();
        dir.delete(); //true

        File tempDir=new File("m");
        tempDir.mkdir();
        File tempFile=new File("m/a.txt");
        tempFile.createNewFile();
        tempDir.delete(); //false

    }
}




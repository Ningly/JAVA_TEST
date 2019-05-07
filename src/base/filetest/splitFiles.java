package base.filetest;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class splitFiles {
    private static final int SIZE = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        File file=new File("C:\\Users\\Ning\\Downloads\\0.mp4");
        File destDir=new File("d:/splitFiles/");
        if(!destDir.exists())
            destDir.mkdirs();
        splitFile(file,destDir);


        File myDestFile=new File("d:/splitFiles/","merge.mp4");
        mergeFiles(destDir,myDestFile);
    }

    private static void mergeFiles(File sourceDir,File destFile) throws IOException {
        File[] files=sourceDir.listFiles(new SuffixFile(".temp"));
        ArrayList<InputStream> list=new ArrayList<>();

        File popFile=sourceDir.listFiles(new SuffixFile(".propertites"))[0];

        Properties properties=new Properties();
        FileInputStream fis=new FileInputStream(popFile);
        properties.load(fis);
        String count = properties.getProperty("count");
        if(Integer.valueOf(count)!=files.length){
            throw new RuntimeException("个数不一致");
        }


        for (File f : files) {
            list.add(new FileInputStream(f));
        }

        SequenceInputStream sis=new SequenceInputStream(Collections.enumeration(list));
        FileOutputStream fos=new FileOutputStream(destFile);
        int len=0;
        byte[] buffer=new byte[SIZE];
        while ((len=sis.read(buffer))!=-1){
            fos.write(buffer, 0, len);
        }




        fos.close();
        sis.close();

    }

    private static void splitFile(File file,File destDir) throws IOException {
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos=null;
        byte[] buffer=new byte[SIZE];
        int count=1;
        int len=0;
        while ((len=fis.read(buffer))!=-1){
            fos=new FileOutputStream(new File(destDir, (count++)+".temp"));
            fos.write(buffer, 0, len);
            fos.flush();
        }
        Properties properties=new Properties();
        FileOutputStream pop=new FileOutputStream(new File(destDir, count +".propertites"));
        properties.setProperty("count",--count+"" );
        properties.store(pop,"all info");
        pop.close();
        fos.close();
        fis.close();
    }




}

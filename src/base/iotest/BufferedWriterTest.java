package base.iotest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("d:/a.txt");

        //为了提高写入效率，使用了字符流缓冲区
        //创建了一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象关联
        BufferedWriter bw=new BufferedWriter(fw);
        //使用缓冲区的写入方法将数据先写入到缓冲区中
        for (int i = 0; i < 4; i++) {
            bw.write("d"+i);
            bw.newLine();
            bw.flush();
        }
        //关闭流
        bw.close();
    }
}

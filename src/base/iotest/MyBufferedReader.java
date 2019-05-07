package base.iotest;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader {
    private Reader r;
    //定义一个数组作为缓冲区
    private char[] buf = new char[1024];
    //定义一个指针用于操作这个数组中的元素，当操作到最后一个元素后，指针应该归零。
    private int pos = 0;
    //定义一个计数器用于记录缓冲区的数据个数，当该数据减到0，就从源中继续获取数据到缓冲区中
    private int count = 0;

    public MyBufferedReader(Reader r) {
        this.r = r;
    }

    /*
     * 从缓冲区中一次取一个数据
     * */
    public int myRead() throws IOException {
        if (count == 0) {
            count = r.read(buf);
            pos = 0;
        }
        if (count < 0)
            return -1;
        char ch = buf[pos];
        pos++;
        count--;
        return ch;
    }

    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while ((ch = myRead()) != -1) {
            if (ch == '\r')
                continue;
            if (ch == '\n')
                return sb.toString();
            sb.append((char) ch);
        }
        if (sb.length() != 0)
            return sb.toString();
        return null;
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {
        r.close();
    }
}

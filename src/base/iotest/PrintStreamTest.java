package base.iotest;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps=new PrintStream("d:/a.txt");
        ps.write(230);  //只写低八位，其它高位字节不写入
        ps.close();

        PrintStream ps1=new PrintStream("d:/b.txt");
        ps1.print(97);  //将97先转换为字符，然后转换为字节
        ps1.close();
    }
}

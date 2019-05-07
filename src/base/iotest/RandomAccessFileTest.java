package base.iotest;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
* 特定：
*1. 该对象既能读也能写
*2. 该对象内部维护了一个byte数组，并通过指针可以操作数组中的元素
* 3. 通过getFilePointer方法获取指针的位置，通过seek方法设置指针的位置
* 4. 其实该对象就是将字节输入流和输出流进行了封装
* 5. 该对象的源或者目的只能是文件。
* */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        writeFile();
        readFile();
        randomWriteFile();
    }

    private static void randomWriteFile() throws IOException {
        RandomAccessFile raf=new RandomAccessFile("d:/aa.txt", "rw");
//       往指定的位置写入信息
        raf.seek(2*10);
        raf.write("后来的".getBytes());
        raf.writeInt(111);
        raf.close();
    }

    private static void readFile() throws IOException {
        RandomAccessFile raf=new RandomAccessFile("d:/aa.txt", "rw");
        byte[] bytes=new byte[6];
        raf.read(bytes);
        String name=new String(bytes);
        int age=raf.readInt();
        System.out.print(name);
        System.out.print(age);
        raf.close();

    }

    private static void writeFile() throws IOException {
        RandomAccessFile raf=new RandomAccessFile("d:/aa.txt", "rw");
        raf.write("你好".getBytes());
        raf.writeInt(97);
        raf.write("张三".getBytes());
        raf.writeInt(107);
        System.out.print("Pointer:"+raf.getFilePointer());
        raf.close();

    }
}

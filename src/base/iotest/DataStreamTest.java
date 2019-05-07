package base.iotest;

import java.io.*;

public class DataStreamTest {
    public static void main(String[] args) throws IOException {
        writeFile();
        readFile();
    }

    private static void readFile() throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream("d:/aa.txt"));
        String i=  dis.readUTF();
        System.out.println(i);
    }

    private static void writeFile() throws IOException {
        DataOutputStream dis=new DataOutputStream(new FileOutputStream("d:/aa.txt"));
        dis.writeUTF("你好");
        dis.close();
    }
}

package base.filetest;

import java.io.*;
import java.util.Properties;

public class PropertityTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("a", "1");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));
        properties.store(bw, "你好");
        bw.close();
    }
}

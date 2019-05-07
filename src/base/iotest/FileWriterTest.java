package base.iotest;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("d:/a.txt");
            fw.write("1111111111" + LINE_SEPARATOR + "222222222222");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }



    }
}

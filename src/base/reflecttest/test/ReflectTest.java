package base.reflecttest.test;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReflectTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException, ClassNotFoundException {
        MainBoard board=new MainBoard();

        // 读取配置
        Properties properties=new Properties();
        properties.load(new FileReader(new File("pci.properties")));
        Set<String> set=properties.stringPropertyNames();
        for (String str : set) {
            Class item = Class.forName(properties.getProperty(str));
            Object obj=item.newInstance();
            board.run((PCI)obj);
        }
    }
}

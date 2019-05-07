package base.otherapi;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemTest {
    public static void main(String[] args){
        Properties properties = System.getProperties();
        System.out.println(properties);

        Set<String> set = properties.stringPropertyNames();
        for (String str : set) {
            String value=properties.getProperty(str);
            System.out.println(str+":"+value);
        }
        System.out.println("======================================");
        Set<Map.Entry<Object,Object>> entrySet = properties.entrySet();
        for (Map.Entry<Object, Object> entry:entrySet){
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println(key+":"+value);
        }

    }
}

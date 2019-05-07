package factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BeanFactory {
/*
    //1. 定义一个properties对象
    private static Properties properties=new Properties();
    //2. 使用静态代码块给对象赋值
    static {
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
            // 绝对不能用，web工程一旦发布，就没有src了
//        properties.load(new FileInputStream("SpringProject/src/bean.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
//------------------------------------------------------------------------------------------

    //1. 只能用于读取properties文件，别的文件读不了
    //2. 他只能用于读取，不能用于写入
    //3. 它只能读取类路径下的文件
    // 注意：不能写扩展名
    private static ResourceBundle bundle = ResourceBundle.getBundle("bean");

    // 定义一个同期，用于存放我们要使用的对象
    private static Map<String, Object> map = new HashMap<>();

    // 初始化map
    static {
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            try {
                String key = keys.nextElement();
                String beanPath = bundle.getString(key);
                Object obj = Class.forName(beanPath).newInstance();
                map.put(key, obj);
            } catch (Exception e) {
                throw new ExceptionInInitializerError("程序初始化失败");
            }
        }
    }
    public static Object getObj(String beanName){
        return map.get(beanName);
    }



    /*
     * 根据beanName创建类对象
     * */
    /*public static Object getObj(String beanName)  {
        try {
            String beanPath=bundle.getString(beanName);
            return Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }*/



    /*public static ICustomerService getCustomerService()  {
        try {
            return (ICustomerService) Class.forName("service.impl.CustomerServiceImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ICustomerDao getCustomerDao()  {
        try {
            return (ICustomerDao) Class.forName("dao.impl.CustomerDaoImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}

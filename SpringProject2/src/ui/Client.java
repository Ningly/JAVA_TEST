package ui;


import config.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ICustomerService;

/*
* spring 入门
* */
public class Client {
    /*
    * ClassPathXmlApplicationContext：只能加载类路径下的配置文件
    * FileSystemXmlApplicationContext：可以加载磁盘任意路径下的配置文件
    *
    * Bean创建的两种规则：
    *  BeanFactory:
    *       提供的是一种延迟加载思想来创建bean对象。bean对象什么时候用什么时候创建
    *  ApplicationContext：
    *       提供的是一种立即加载思想来创建bean对象。只要一解析完配置文件，就立马来创建对象
    * */
    @SuppressWarnings("all")
    public static void main(String[] args){
        //1. 获取容器
//        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac=new ClassPathXmlApplicationContext("config/bean.xml");
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml", Configuration.class);

        /*Resource resource=new ClassPathResource("bean.xml");
        BeanFactory factory=new XmlBeanFactory(resource);*/
        
        
        //2. 根据bean的id获取对象
        ICustomerService cs= (ICustomerService) ac.getBean("instanceService");
        cs.saveCustomer();
        /*ICustomerDao cdao= (ICustomerDao) ac.getBean("customerDao");
        cdao.saveCustomer();
        System.out.println(cs);
        System.out.println(cdao);*/
    }
}

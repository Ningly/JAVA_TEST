package base.nettest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost=InetAddress.getByName("www.sina.com.cn");// InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());



        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());



    }
}

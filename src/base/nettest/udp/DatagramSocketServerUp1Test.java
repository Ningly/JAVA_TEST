package base.nettest.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramSocketServerUp1Test {
    public static void main(String[] args) throws IOException {
        /*
        * 创建UDP接收端的思路：
        * 1. 建立DatagramSocket服务
        * 2. 创建数据包DatagramPacket，用于存储接收到的数据，方便用数据包对象的方法解析这些数据
        * 3. 使用Socket服务的receive方法将接收到的数据存储到数据包中
        * 4. 通过数据包的方法解析数据包中的数据
        * 5. 关闭资源
        * */

        DatagramSocket ds=new DatagramSocket(10000);
        byte[] bytes=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
        while (true){
            ds.receive(dp); //阻塞方法
            int port=dp.getPort();//获取发送端的端口
            String str=new String(dp.getData(),0,dp.getLength());
            System.out.println(str);
        }
    }
}

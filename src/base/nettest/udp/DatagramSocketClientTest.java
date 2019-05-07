package base.nettest.udp;

import java.io.IOException;
import java.net.*;

public class DatagramSocketClientTest {
    public static void main(String[] args) throws IOException {
        /*
        * 创建UDP传输的发送帧
        * 1. 建立UPD的Socket服务
        * 2. 将要发送的数据封装到数据包DatagramPacket中
        * 3. 通过UDP的Socket服务将数据包发送出去
        * 4. 关闭Socket服务
        * */

        DatagramSocket ds=new DatagramSocket(); //发送端的port是任意的
        String str="i'm coming";
        byte[] bytes=str.getBytes();
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("localhost"),10000);
        ds.send(dp);
        ds.close();
    }
}

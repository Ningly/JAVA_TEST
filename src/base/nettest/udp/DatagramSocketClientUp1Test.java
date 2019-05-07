package base.nettest.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSocketClientUp1Test {
    public static void main(String[] args) throws IOException {
        /*
        * 创建UDP传输的发送帧
        * 1. 建立UPD的Socket服务
        * 2. 将要发送的数据封装到数据包DatagramPacket中
        * 3. 通过UDP的Socket服务将数据包发送出去
        * 4. 关闭Socket服务
        * */

        DatagramSocket ds=new DatagramSocket(); //发送端的port是任意的
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=br.readLine())!=null){
            if("over".equals(line))
                break;
            byte[] bytes=line.getBytes();
            DatagramPacket dp=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("localhost"),10000);
            ds.send(dp);
        }
        ds.close();
    }
}

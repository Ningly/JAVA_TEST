package base.nettest.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ChatUdpDemo {
    public static void main(String[] args) throws SocketException {
        DatagramSocket send=new DatagramSocket();
        DatagramSocket rece=new DatagramSocket(10000);
        SendTask sendTask=new SendTask(send);
        ReceTask receTask=new ReceTask(rece);
        new Thread(sendTask).start();
        new Thread(receTask).start();
    }
}

class SendTask implements Runnable{
    DatagramSocket ds;

    public SendTask(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        while (true){
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String line=null;
            try {
                if (!((line=br.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bytes=line.getBytes();
            DatagramPacket dp= null;
            try {
                dp = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("localhost"),10000);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            try {
                ds.send(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if("over".equals(line))
                break;

        }
        ds.close();
    }
}
class ReceTask implements Runnable{
    DatagramSocket ds;

    public ReceTask(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {

        while (true){
            byte[] bytes=new byte[1024];
            DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
            try {
                ds.receive(dp); //阻塞方法
            } catch (IOException e) {
                e.printStackTrace();
            }
            int port=dp.getPort();//获取发送端的端口
            String ip=dp.getAddress().getHostAddress();
            String str=new String(dp.getData(),0,dp.getLength());
            if("over".equals(str)){
                System.out.println("ip:"+ip+",port:"+port+"info:已退出了聊天");
            }
            System.out.println("ip:"+ip+",port:"+port+",info:"+str);
        }
    }
}
package base.nettest.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        /*
        * TCP传输，客户端建立的过程
        * 1. 创建TCP客户端socket服务，使用socket对象
        *       建议该对象创建就明确目的地，端口
        * 2. 如果连接建立成功，说明数据传输通道已建立
        *       该通道就是socket流，是底层建立好的，既然是流，说明这里有输入，又有输出
        *       想要输入或者输出流对象，可以找socket来获取
        *       可以通过getOutputStream()和getInputStream()来获取字节流
        * 3. 使用输出流，将数据输出
        * 4. 关闭资源
        * */

        //创建客户端socket服务
        Socket socket=new Socket("localhost", 10002);
        //获取socket流中的输出流
        OutputStream out=socket.getOutputStream();
        //使用输出流将指定的数据写出去
        out.write("i'coming ".getBytes());


        InputStream inputStream=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=inputStream.read(bytes);
        String txt=new String(bytes,0,len);
        String ip=socket.getInetAddress().getHostAddress();
        System.out.println(ip+":"+txt);

        //关闭资源
        socket.close();
    }
}

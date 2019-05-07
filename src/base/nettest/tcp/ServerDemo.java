package base.nettest.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        /*
        * 建立TCP服务端的思路：
        * 1. 创建服务端socket服务，通过ServerSocket对象。
        * 2. 服务端必须对外提供一个端口，否则客户端无法连接
        * 3. 获取连接过来的客户端对象
        * 4. 通过客户端对象获取socket流读取客户端发来的数据
        * 5. 关闭资源；关客户端，关服务端
        * */

        //创建服务端对象
        ServerSocket serverSocket=new ServerSocket(10002);
        // 获取连接过来的客户端对象
        Socket socket=serverSocket.accept();
        // 通过socket对象获取输入流，尧都区客户端发来的数据
        InputStream inputStream=  socket.getInputStream();
        //
        byte[] bytes=new byte[1024];
        int len=inputStream.read(bytes);
        String txt=new String(bytes,0,len);
        String ip=socket.getInetAddress().getHostAddress();
        System.out.println(ip+":"+txt);



        OutputStream out=socket.getOutputStream();
        //使用输出流将指定的数据写出去
        out.write("server received".getBytes());


        socket.close();
        serverSocket.close();
    }
}

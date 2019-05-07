package base.nettest.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServerDemo {
    public static void main(String[] args) throws IOException {
        //1. 创建服务端对象
        ServerSocket serverSocket=new ServerSocket(10005);
        // 2. socket 对象
        Socket socket=serverSocket.accept();

        BufferedInputStream bufferedInputStream=new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("0.png"));
        byte[] buffer = new byte[1024];
        int len=0;
        while ((len=bufferedInputStream.read(buffer))!=-1){
            bufferedOutputStream.write(buffer, 0, len);
            bufferedOutputStream.flush();
        }

        System.out.println("服务端：读取完毕");

        // 3.通知客户端

        PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
        printWriter.println("服务端：接收完成");

        bufferedOutputStream.close();
        socket.close();
        serverSocket.close();
    }
}

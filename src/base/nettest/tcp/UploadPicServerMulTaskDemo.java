package base.nettest.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServerMulTaskDemo {
    public static void main(String[] args) throws IOException {
        //1. 创建服务端对象
        ServerSocket serverSocket=new ServerSocket(10005);
        while (true){
            // 2. socket 对象
            Socket socket=serverSocket.accept();
            new Thread(new UploadTask(socket)).start();
        }
    }
}


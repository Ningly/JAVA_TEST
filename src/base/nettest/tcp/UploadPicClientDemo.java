package base.nettest.tcp;

import java.io.*;
import java.net.Socket;

public class UploadPicClientDemo {
    public static void main(String[] args) throws IOException {
        //1. 创建客户端socket
        Socket socket=new Socket("localhost", 10005);
        //2. socket 输出流

        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(socket.getOutputStream());
        //3. 要上传的文件
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("1.png"));

        byte[] buffer=new byte[1024];
        int len=0;
        while ((len=bufferedInputStream.read(buffer))!=-1){
            bufferedOutputStream.write(buffer,0,len);
            bufferedOutputStream.flush();
        }

        socket.shutdownOutput();
        System.out.println("客户端：读取完毕");
        // 4. 接收服务端信息
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("客户端："+bufferedReader.readLine());

        bufferedInputStream.close();
        socket.close();
    }
}

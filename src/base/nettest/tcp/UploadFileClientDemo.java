package base.nettest.tcp;

import java.io.*;
import java.net.Socket;

public class UploadFileClientDemo {
    public static void main(String[] args) throws IOException {
        // 1. 创建socket对象
        Socket socket=new Socket("localhost", 10003);
        // 2. 读取本地文件
        BufferedReader bufferedReader=new BufferedReader(new FileReader("a.txt"));
        // 3. socket 输出流
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;
        while ((line=bufferedReader.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        System.out.println("客户端：读取完毕");
        // EOF（文件结束符）。
        socket.shutdownOutput();

        /*bufferedWriter.write("over");
        bufferedWriter.newLine();
        bufferedWriter.flush();*/
        bufferedReader.close();

        //4. 获取服务端的响应
        InputStream inputStream=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }


        socket.close();
    }
}

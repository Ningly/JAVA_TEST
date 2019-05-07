package base.nettest.tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadFileServerDemo {
    public static void main(String[] args) throws IOException {
        // 1. 创建serversocket对象
        ServerSocket serverSocket=new ServerSocket(10003);
        //2. 获取socket第项
        Socket socket=serverSocket.accept();
        System.out.println(socket.getInetAddress().getHostAddress()+"....connected");
        //3. 获取socket 输入流
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("server.txt"));
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line=bufferedReader.readLine())!=null){
            /*if("over".equals(line))
                break;*/
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        System.out.println("服务端：读取完毕");
        bufferedWriter.close();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("已收到文件".getBytes());
        socket.close();
        serverSocket.close();
    }
}

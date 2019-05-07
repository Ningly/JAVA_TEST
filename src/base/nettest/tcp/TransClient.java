package base.nettest.tcp;

import java.io.*;
import java.net.Socket;

public class TransClient {
    public static void main(String[] args) throws IOException {
        //1. 创建socket客户端对象
        Socket socket = new Socket("127.0.0.1", 10002);
        // 2. 获取键盘录入
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 3. socket输出流
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);

//        socket输入流
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String lien;
        while ((lien = bufferedReader.readLine())!=null){
//            bufferedWriter.write(lien);
//            bufferedWriter.flush();

            printWriter.println(lien);
            if ("over".equals(lien)) {
                break;
            }



            String lien1 = bufferedReader1.readLine();
            System.out.println("客户端接收：" + lien1);
        }
        socket.close();
    }
}

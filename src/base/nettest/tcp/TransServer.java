package base.nettest.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10002);
        Socket socket = serverSocket.accept();

        String ip=socket.getInetAddress().getHostAddress();
        System.out.println("ip:"+ip);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);

        String lien;
        while ((lien = bufferedReader.readLine())!=null){
//            if ("over".equals(lien)) {
//                break;
//            }
            System.out.println("服务端：" + lien);

            printWriter.println(lien.toUpperCase());
//            bufferedWriter.write(lien.toUpperCase());
//            bufferedWriter.flush();
        }


        socket.close();
        serverSocket.close();
    }
}

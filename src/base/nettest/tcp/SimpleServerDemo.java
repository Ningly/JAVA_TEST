package base.nettest.tcp;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(10005);

        while (true){
            Socket socket=serverSocket.accept();
            new Thread(new SimpleTask(socket)).start();
        }
    }
}
class SimpleTask implements Runnable{

    private Socket socket;

    public SimpleTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String ip=socket.getInetAddress().getHostAddress();
        System.out.println(ip+".........connected");

        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                if("".equals(line))
                    break;
            }

            PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("ok");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
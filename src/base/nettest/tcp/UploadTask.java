package base.nettest.tcp;

import java.io.*;
import java.net.Socket;

public class UploadTask implements Runnable{
    private Socket socket;

    public UploadTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        int count=0;
        try {
            BufferedInputStream bufferedInputStream=new BufferedInputStream(socket.getInputStream());


            String ip=socket.getInetAddress().getHostAddress();
            File file=new File(ip+".png");
            while (file.exists())
                file=new File(ip+"("+ ++count+").png");

            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file));

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
        }
        catch (IOException e){

        }
    }
}

package base.iotest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


/*
* PipedOutputStream:发送端，写入数据到管道
* PipedInputStream:接收端，从管道中读取
* */
public class PipedOutputStreamTest {
    public static void main(String[] args) throws IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        inputStream.connect(outputStream);
        new Thread(new Input(inputStream)).start();
        new Thread(new Output(outputStream)).start();
    }
}


class Input implements Runnable {

    private PipedInputStream inputStream;

    public Input(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        byte[] bytes = new byte[1024];
        try {
            while (true){
                int len = inputStream.read(bytes);
                String s = new String(bytes, 0, len);
                System.out.println("s=" + s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}

class Output implements Runnable {

    private PipedOutputStream outputStream;

    public Output(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
            try {

                while (true){
                    Thread.sleep(1000);
                    outputStream.write("come in".getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}
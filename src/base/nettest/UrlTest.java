package base.nettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {
    public static void main(String[] args) throws IOException {
        String str_url="https://www.baidu.com";
        URL url=new URL(str_url);
        System.out.println(url.getProtocol());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getPort());
        System.out.println(url.getFile());


        URLConnection connection=url.openConnection();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line=bufferedReader.readLine())!=null){
            if("".equals(line))
                break;
            System.out.println(line);
        }
    }
}

package base.regextest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlerTest {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://www.hao123.com/");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(url.openStream()));
        // 创建正则对象
        String regex="\\w+@\\w+.(\\w+)+";
        Pattern pattern=Pattern.compile(regex);

        String line;
        while ((line=bufferedReader.readLine())!=null){
            Matcher matcher=pattern.matcher(line);
            while (matcher.find())
                System.out.println(matcher.group());
        }
    }
}

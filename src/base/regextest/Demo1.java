package base.regextest;

import java.util.regex.Pattern;

public class Demo1 {
    public static void main(String[] args){
        String regex="[1-9][0-9]{4,14}";

        boolean flag = Pattern.matches(regex, "123456");
        boolean flag1 = regex.matches("0123456");

        System.out.println(flag);
        System.out.println(flag1);
    }
}

package base.regextest;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo2 {
    public static void main(String[] args) {
        // 匹配：String类中的matches()
        //demo1();
        // 切割：String类中的split()
        //demo2();
        // 替换：String类中的replaceAll()
        //demo3();
        // 获取
        /*
          1. 将政策规则进行对象的封装
        * Pattern p = Pattern.compile("a*b");
        * 2. 通过正则对象的matcher方法字符串相关联，获取要对字符串操作的匹配器对象Matcher
          Matcher m = p.matcher("aaaaab");
          3. 通过Matcher匹配器对象的方法对字符串进行操作
          boolean b = m.matches();
        *
        * */
        demo4();

    }

    private static void demo4() {
        String str = "da jia hao,ming tian bu fang jia";
        String regex = "\\b[a-z]{3}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.start()+":"+matcher.end());
        }

    }

    private static void demo3() {
        String name1 = "xyz attttbmmmmmmcnnnnnnd";
        String regex1 = "(.)\\1+";
        String str = name1.replaceAll(regex1, "$1");
        System.out.println(str);

        String phone = "17621970990";
        // $1 : 匹配组1
        String str1 = phone.replaceAll("(\\d{3})\\d{4}(\\d{3})", "$1****$2");
        System.out.println(str1);
    }

    private static void demo2() {
        String name1 = "a.b.c.d";
        // 第一个转义字符\把第二个\转移了（此时第二个\变成普通字符\）,此时字符串变为\.
        // 此时第二个\修饰.时，把.原来的意思给转义为普通字符.
        String regex1 = "\\.";
        String[] arr1 = name1.split(regex1);
        for (String n : arr1) {
            System.out.print(n);
        }
        System.out.println("");

        String name = "a   b   c             d";
        // 第一个\转移第二个\,此时字符串变为\s
        // 此时字符串为 预定义字符类的 \s
        String regex = "\\s*";
        String[] arr = name.split(regex);
        for (String n : arr) {
            System.out.print(n);
        }
        System.out.println("");


        String name2 = "attttbmmmmmmcnnnnnnd";
        String regex2 = "(.)\\1+";//"[tmn]{3,}";
        String[] arr2 = name2.split(regex2);
        for (String n : arr2) {
            System.out.print(n);
        }
        System.out.println("");
    }

    private static void demo1() {
        String phone = "17621970990";
        String regex = "1[3578]\\d{9}";  //"1[3578][0-9]{9}";
        boolean flag = phone.matches(regex);
        System.out.println(flag);
    }
}

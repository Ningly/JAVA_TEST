package base.regextest;

import java.util.TreeSet;

public class DemosTest {
    public static void main(String[] args) {
//        demo1(); //去重
//        demo2(); // IP排序
        demo3(); // 邮箱验证
    }

    private static void demo3() {
        String mail="1430015771@qq.com";
        String regex="\\w+@\\w+\\.[a-zA-Z]{2,3}";
        boolean flag = mail.matches(regex);
        System.out.println(flag);
    }

    private static void demo2() {
        String str="190.168.0.1    425.5.0.1    196.2.68.2";
        //1. 为了让ip可以按照字符串顺序比较，只要让Ip的每一段的位数相同
        //    所以，补零，按照每一位所需做多0进行补充，每一段都加两个0
        str=str.replaceAll("(\\d+)","00$1");
        System.out.println(str);
        // 2. 保留3位
        str=str.replaceAll("0*(\\d{3})", "$1");
        System.out.println(str);

        String[] arr=str.split(" +");
        TreeSet<String> set=new TreeSet<>();
        for (String item : arr) {
            set.add(item);
        }
        for (String item : set) {
            System.out.println(item.replaceAll("0*(\\d+)", "$1"));
        }

    }

    private static void demo1() {
        String str="我我我........要要要...学学学学学学..编编编编编.....程";
        str=str.replaceAll("(\\.)+", "");
        str=str.replaceAll("(.)\\1{2,}","$1");
        System.out.println(str);
    }
}





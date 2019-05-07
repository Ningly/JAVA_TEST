package base.apis.stringDemos;

/*
 * 按照字典顺序从小到大进行排序
 * */
public class StringDemo0 {
    public static void main(String[] args) {
        String[] arr = {"nba", "abc", "cba", "zz", "qq", "h"};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("=====================");
        String str = "nbanbanbanbanbanbanbanba";
        int count = 0;
        int index=0;
        for (int i = 0; i < str.length(); ) {
            if (str.indexOf("nba",i) >= 0) {
                i+=3;
                count++;
            }
        }
        System.out.println(count);
    }
}

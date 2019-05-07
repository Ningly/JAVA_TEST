package base.collectiontest;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,2,1};
        System.out.println(Arrays.toString(arr));


        String[] arrStr={"Larry", "Moe", "Curly"};
        List<String> stooges = Arrays.asList(arrStr);
//        stooges.add("a");   //UnsupportedOperationException
        System.out.println(stooges);



        /*
        * 如果数组中元素是对象，那么转成集合时，直接将数组中的元素作为集合中的元素进行集合存储
        * 如果数组中的元素是基本类型数值，那么会将该数组作为集合中的元素进行存储。
        * */

        int[] arr1={1,2,3,4,2,1};
        List<int[]> list=Arrays.asList(arr1);
        System.out.println(list);    //[[I@1b6d3586]
        System.out.println((list.get(0))[0]);  //1





        List<String > stringList=new ArrayList<>();
        stringList.add("a1");
        stringList.add("a2");
        stringList.add("a3");

        /*
        *toArray()需要传入一个指定类型的数组。
        * 长度如何定义呢？
        * 如果长度小于集合的size()，那么该方法会创建一个和集合长度相同的size()的数组
        * 如果长度大于集合的size()，那么该方法就会使用指定的数组，存储集合中的元素，其他位置默认为null
        *
        * 所以建议长度指定为集合的size()
        * */
        String[] arr3=stringList.toArray(new String[stringList.size()]);
        System.out.println(Arrays.toString(arr3));


        for (String str : stringList) {
            System.out.println(str);
        }




    }


    public static int newAdd(int... arr){
        for (int i : arr) {

        }
        return 0;
    }
}

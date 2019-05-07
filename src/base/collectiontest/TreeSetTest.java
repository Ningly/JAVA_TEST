package base.collectiontest;

import base.bean.TreeSetPerson;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet set=new TreeSet(new ComparatorByName());
        set.add(new TreeSetPerson("a",1));
        set.add(new TreeSetPerson("u",2));
        set.add(new TreeSetPerson("c",3));
        set.add(new TreeSetPerson("a",1));



        for (Iterator iterator = set.iterator(); iterator.hasNext();){
            TreeSetPerson p=(TreeSetPerson)iterator.next();
            System.out.println(p);
        }


        System.out.println("================================================");


        TreeSet ts=new TreeSet(new ComparatorStringByLength());
        ts.add("zzz");
        ts.add("abc");
        ts.add("cba");
        ts.add("abcd");
        for (Iterator iterator = ts.iterator(); iterator.hasNext();){
            String p=(String)iterator.next();
            System.out.println(p);
        }
    }
}

class ComparatorStringByLength implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        int temp=o1.length()-o2.length();
        return temp==0?o1.compareTo(o2):temp;
    }
}

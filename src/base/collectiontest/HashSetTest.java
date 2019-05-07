package base.collectiontest;

import base.bean.Person;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet set=new HashSet();
        set.add(new Person("a",1));
        set.add(new Person("b",2));
        set.add(new Person("c",3));
        set.add(new Person("a",1));

        for (Iterator iterator=set.iterator();iterator.hasNext();){
            Person p=(Person)iterator.next();
            System.out.println(p);
        }
    }
}

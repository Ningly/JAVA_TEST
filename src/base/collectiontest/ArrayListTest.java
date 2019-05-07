package base.collectiontest;

import base.bean.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.add(new Person("list1",21));
        list.add(new Person("list2",22));
        list.add(new Person("list3",23));
        list.add(new Person("list4",24));
        list.add(new Person("list5",25));


        for (Iterator iterator=list.iterator();iterator.hasNext();){
            System.out.println(((Person)(iterator.next())).getName());
        }
    }
}

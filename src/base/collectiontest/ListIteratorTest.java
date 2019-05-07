package base.collectiontest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);


        /*for (Iterator iterator = list.iterator(); iterator.hasNext();){
            Object obj=iterator.next();
            if(obj.equals(2))
                list.add(8); //java.util.ConcurrentModificationException
            else
                System.out.println(obj);
        }*/


        for (ListIterator iterator = list.listIterator(); iterator.hasNext();){
            Object obj=iterator.next();
            if(obj.equals(2))
                iterator.add(8);
        }
        System.out.println(list);
        for (ListIterator iterator=list.listIterator();iterator.hasPrevious();){
            System.out.println(iterator.previous());
        }
        System.out.println(list);
    }
}

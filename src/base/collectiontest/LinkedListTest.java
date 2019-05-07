package base.collectiontest;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);

        for (Iterator iterator=linkedList.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}

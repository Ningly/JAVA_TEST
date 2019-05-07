package base.collectiontest;

import java.util.*;

public class VectorTest {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add(1);
        v.add(2);
        v.add(3);


        for (Enumeration elements = v.elements();elements.hasMoreElements();){
            System.out.println(elements.nextElement());
        }

        for (Iterator iterator=v.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }

        for (ListIterator iterator = v.listIterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}

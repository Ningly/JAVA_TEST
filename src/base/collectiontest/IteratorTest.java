package base.collectiontest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        Collection collection=new ArrayList();
        collection.add(1);
        collection.add(2);
        collection.add(3);


        for (Iterator iterator=collection.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }

        Iterator iterator1=collection.iterator();
        while (iterator1.hasNext())
            System.out.println(iterator1.next());
    }
}

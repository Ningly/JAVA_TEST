package base.collectiontest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection collection=new ArrayList();
        show(collection);
    }

    public static void show(Collection collection){
        //1. 添加元素
        collection.add(1);
        collection.add(2);
        collection.add(3);
        System.out.println(collection);

        //2. 删除元素
        collection.remove(1);
        System.out.println(collection.contains(1));
        System.out.println(collection);

        collection.containsAll(new ArrayList<Integer>());



    }

}

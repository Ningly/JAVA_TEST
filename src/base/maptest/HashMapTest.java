package base.maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args){
        Map<Integer,String> map= new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(2,"b");
        map.put(3,"c");
        /*Set set = map.keySet();
        for (Iterator iterator=set.iterator();iterator.hasNext();){
            Object obj= iterator.next();
            System.out.println(map.get(obj));
        }*/



        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        for (Iterator<Map.Entry<Integer,String>> iterator=entrySet.iterator();iterator.hasNext();){
            Map.Entry<Integer,String> entry=iterator.next();
            Integer integer=entry.getKey();
            String string=entry.getValue();
            System.out.println("key="+integer+"   value="+string);
        }
    }
}

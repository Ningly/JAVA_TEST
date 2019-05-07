package base.collectiontest;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args){
        ArrayList<String> list=new ArrayList<>();
        list.add("ava");
        list.add("vad");
        list.add("aged");
        list.add("mal");
        mySort(list);
        System.out.println(list);

        mySort(list,new ComparatorStringByLength());
        System.out.println(list);
    }

    public static <T> void mySort(List<T> list, Comparator<? super T> comparator){
        for (int i=0;i<list.size()-1;i++){
            for (int j = i+1; j < list.size(); j++) {
                if(comparator.compare(list.get(i),list.get(j))>0){
                    Collections.swap(list,i,j);
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void mySort(List<T> list){
        for (int i=0;i<list.size()-1;i++){
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).compareTo(list.get(j))>0){
                    T temp=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }
}


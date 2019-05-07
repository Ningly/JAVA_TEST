package base.generictest;

import base.bean.GenericPerson;

import java.util.Comparator;
import java.util.TreeSet;

public class GenericTreeSetTest {
    public static void main(String[] args) {
        TreeSet<GenericPerson> set= new TreeSet<>(new GenericPersonCompactorByAge());
        set.add(new GenericPerson("a",1));
        set.add(new GenericPerson("b",7));
        set.add(new GenericPerson("c",4));
        set.add(new GenericPerson("e",2));

        for (GenericPerson person : set) {
            System.out.println(person.getName() + ":" + person.getAge());
        }
    }
}

class GenericPersonCompactorByAge implements Comparator<GenericPerson>{

    @Override
    public int compare(GenericPerson o1, GenericPerson o2) {
        return o1.getAge()-o2.getAge();
    }
}
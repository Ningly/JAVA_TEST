package base.collectiontest;

import base.bean.TreeSetPerson;

import java.util.Comparator;

public class ComparatorByName implements Comparator<TreeSetPerson> {

    @Override
    public int compare(TreeSetPerson o1, TreeSetPerson o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

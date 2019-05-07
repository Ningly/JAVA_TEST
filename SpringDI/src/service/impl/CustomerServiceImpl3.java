package service.impl;

import service.ICustomerService;

import java.util.*;

public class CustomerServiceImpl3 implements ICustomerService {

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String > myMap;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProp(Properties myProp) {
        this.myProp = myProp;
    }

    private Properties myProp;
    @Override
    public void saveCustomer() {
        System.out.println("业务层调用了持久层:");
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(myMap);
        System.out.println(mySet);
        System.out.println(myProp);

    }
}

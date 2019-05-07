package com.domain;

public class Students {
    private int Id;
    private String FirstName;
    private String LastName;
    private int Gender;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    @Override
    public String toString() {
        return "Students{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Gender=" + Gender +
                '}';
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }
}

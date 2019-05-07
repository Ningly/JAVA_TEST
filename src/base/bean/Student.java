package base.bean;

public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    public Student() {
        super();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

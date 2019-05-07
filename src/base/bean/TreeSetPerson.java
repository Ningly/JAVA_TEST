package base.bean;

public class TreeSetPerson implements Comparable<TreeSetPerson> {
    private String name;
    private int age;

    public TreeSetPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TreeSetPerson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
//        System.out.println("hashCode");
        return this.getName().hashCode()+this.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        TreeSetPerson p=(TreeSetPerson)obj;
//        System.out.println(p.getName()+":"+p.getAge()+"......equals------"+this.getName()+":"+this.getAge());
        return this.getName()==p.getName()&&this.getAge()==p.getAge();
    }

    @Override
    public String toString() {
        return this.getName()+":"+this.getAge();
    }

    @Override
    public int compareTo(TreeSetPerson o) {
        return this.age-o.age;
    }
}

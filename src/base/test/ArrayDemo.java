package base.test;

class ArrayDemo {

    // args:new String[0] => JVM默认传递的数值
    public static void main(String[] args) {

        System.out.println(args.length);  //0
        System.out.println(args);  //[Ljava.lang.String;@1b6d3586

        System.out.println(Test.instance==Test.instance);
        System.out.println(Test.instance);
        System.out.println(Test.instance);
    }

    public static void main(int[] args) {}

}

class Test{
    private Test() {
    }

    public static Test instance=new Test();
}

class Student {

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int age;
    public static String name;

    public static void speak(){
        System.out.println(name+(new Student()).age);
    }
}

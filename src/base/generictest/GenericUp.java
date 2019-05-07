package base.generictest;

import base.bean.Person;
import base.bean.Student;
import base.bean.Worker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericUp {
    public static void main(String[] args) {
        Collection<Person> person = new ArrayList<>();
        person.add(new Person("p1", 1));
        person.add(new Person("p2", 2));
        person.add(new Person("p3", 3));
        printPerson(person);
        System.out.println("==============printDown==================");
        Collection<Student> students = new ArrayList<>();
        students.add(new Student("s1", 1));
        students.add(new Student("s2", 2));
        students.add(new Student("s3", 3));
        printDown(students);
        System.out.println("==============printUp==================");
        Collection<Worker> workers = new ArrayList<>();
        workers.add(new Worker("w1", 1));
        workers.add(new Worker("w2", 2));
        workers.add(new Worker("w3", 3));
        printUp(workers);
        //printDown(workers);  //error
    }

    // 泛型通配符：?
    public static void printPerson(Collection<?> collection) {
        for (Iterator<?> iterator = collection.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

    // 泛型通配符：?  对类型进行上限限定
    public static void printUp(Collection<? extends Person> collection) {
        for (Iterator<? extends Person> iterator = collection.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
    // 泛型通配符：?  对类型进行下限限定
    public static void printDown(Collection<? super Student> collection) {
        for (Iterator<? super Student> iterator = collection.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

    // 静态方法泛型【不常用】
    public static <T> void printStatic(Collection<T> collection) {
        for (Iterator<T> iterator = collection.iterator(); iterator.hasNext(); ) {
            T t=iterator.next();
            System.out.println(t);
        }
    }
}

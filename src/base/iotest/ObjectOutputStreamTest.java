package base.iotest;

import base.bean.Person;

import java.io.*;

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("d:/a.object"));
        oos.writeObject(new Person("a",1));
        oos.close();*/

        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("d:/a.object"));
        Person p = (Person) ois.readObject();
        System.out.print(p.getName());
    }
}

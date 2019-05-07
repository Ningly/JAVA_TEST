package base.design;

public class PersonDemo {
    public static void main(String[] args) {
        OldPerson oldPerson = new OldPerson();
//        oldPerson.eat();

        NewPerson newPerson = new NewPerson(oldPerson);
        newPerson.eat();


        NewPerson2 newPerson2 = new NewPerson2();
        newPerson2.eat();
    }
}


class OldPerson {
    void eat() {
        System.out.println("eat");
    }
}

/*
 * 这个类的出现是为了增强OldPerson而出现的，这就是所谓的增强
 * */
class NewPerson {
    private OldPerson person;

    public NewPerson(OldPerson person) {
        this.person = person;
    }

    void eat() {
        person.eat();
        System.out.println("eat good");
    }
}


class NewPerson2 extends OldPerson {
    void eat() {
        super.eat();
        System.out.println("eat good");
    }
}

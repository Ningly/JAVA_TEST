public class ExtendsDemo {
    public static void main(String[] args){
        Zi z=new Zi();
        z.show();
    }
}
class Fu{
    public Fu() {
        super();  //可写可不写；不写，JAVA编译器在编译时自动添加
        show();  //==>this.show();   this关键字代表的是所属函数的调用者对象。
        //所属函数：Fu()      调用者对象：new Zi()
        return;  //可写可不写；不写，JAVA编译器在编译时自动添加
    }
    void show(){
        System.out.println("fu show");
    }
}
class Zi extends Fu{
    int num=8;
    public Zi() {
        super(); //可写可不写；不写，JAVA编译器在编译时自动添加
        //==>通过super()初始化父类内容时，子类的成员变量尚未显示初始化；
        //等super()父类初始化完毕后，才进行子类成员变量显示初始化
        System.out.println("zi ctor show......."+num);
        return; //可写可不写；不写，JAVA编译器在编译时自动添加
    }
    void show(){
        System.out.println("zi show......."+num);
    }
}


package base.generictest;

/*
* 将泛型类定义在类上
* */
public class DefGenericClassTest<T> {
    T t=null;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
    /*
    * 将泛型类定义在方法上
    * */
    public <W> void show(W w){
        System.out.println(w);
    }
    /*
    * 当方法静态时，不能访问类上定义的泛型；
    * 泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型
     * 如果静态方法使用泛型，只能将泛型定义在方法上。
    * */
    public static <Z> void method(Z z){
        System.out.println(z);
    }

}

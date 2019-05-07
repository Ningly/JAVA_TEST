package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final Actor actor=new Actor();

        /*
        *动态代理：
        *   作用：不改变源码的基础上，对已有方法增强。（他是AOP思想的实现技术）
        *   分类：
        *       基于接口的动态代理：
        *           要求：被代理类最少实现一个接口
        *           提供者：JDK官方
        *           涉及的类：Proxy
        *       创建代理对象的方法：newProxyInstance(ClassLoader,Class[],InvocationHandler)
        *           参数的含义：
        *               ClassLoader：类加载器。和被代理对象使用相同的类加载器。一般都是固定写法。
        *               Class[]：字节码数组。被代理类实现的接口。（要求代理对象和被代理对象具有相同的行为）。一般都是固定写法。
        *               InvocationHandler：它是一个接口，就是用于我们提供增强代码的。我们一般都是些一个该接口的实现类。实现类可以是匿名内部类。
        *                                  他的含义：如何代理。
        *                                  策略模式：
        *                                       使用要求：1. 数据已经有了  2. 目的明确
        *                                           达成目标的过程就是策略
        *                                           在dbutils中ResultSetHandler就是策略模式的具体应用
        *
        * */
        IAct proxyAct = (IAct) Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), new InvocationHandler() {
            /*
            * 执行被代理对象的任何方法都会经过该方法，该方法有拦截的功能
            * 方法参数：
            *     Object proxy：代理对象的引用。不一定每次都会用
            *     Method method：当前执行的方法
            *     Object[] args：当前执行方法所需的参数
            * 返回值：
            *     当前执行方法的返回值。
            * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res=new Object();
                float money=(float)args[0];
                if("basicAct".equals(method.getName())){
                    if(money>10000)
                        method.invoke(actor, money);
                }
                if("dangerAct".equals(method.getName())){
                    if(money>50000)
                        method.invoke(actor, money);
                }

                return res;
            }
        });

        proxyAct.basicAct(50000);
        proxyAct.dangerAct(50000);
    }
}






























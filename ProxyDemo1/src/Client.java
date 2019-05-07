import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Actor actor=new Actor();
        /*actor.act(1);
        actor.dangerAct(2);*/


        IActor proxyActor=(IActor) Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj=new Object();
                float money=(float)args[0];
                if("act".equals(method.getName())){
                    if(money>1000){
                        method.invoke(actor, money);
                    }
                }
                if("dangerAct".equals(method.getName())){
                    if(money>2000){
                        method.invoke(actor, money);
                    }
                }
                return obj;
            }
        });
        proxyActor.act(10001);
        proxyActor.dangerAct(20001);
    }
}

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyDataSource {
    //定义一个池,用于存放连接
    private static List<Connection> pool= Collections.synchronizedList(new ArrayList<>());
    //使用静态代码块给池中加入连接
    static {
        for (int i = 0; i < 10; i++) {
            Connection conn = JDbcUtil.getConnection();
            pool.add(conn);
        }
    }


    public static Connection getConncetion() {
        Connection conn=pool.remove(0);
        Connection proxyConn=(Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj=new Object();
                if("close".equals(method.getName())){
                    pool.add(conn);
                }else
                {
                    obj=method.invoke(conn, args);
                }
                return obj;
            }
        });
        return proxyConn;
    }

    public static int getPoolSize() {
        return pool.size();
    }
}

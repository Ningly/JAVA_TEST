import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyDataSouceHelper {

    private static List<Connection> pool = Collections.synchronizedList(new ArrayList<>());

    static {
        for (int i = 0; i < 5; i++) {
            pool.add(JDbcUtil.getConnection());
        }

    }

    public static Connection getConnection() {
        Connection conn = pool.remove(0);
        Connection proxyConn = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = new Object();
                if("close".equals(method.getName())){
                    pool.add(conn);
                }else{
                    obj = method.invoke(conn, args);
                }
                return obj;
            }
        });
        return proxyConn;
    }
}

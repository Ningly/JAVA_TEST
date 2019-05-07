import java.sql.Connection;
import java.sql.DriverManager;

public class JDbcUtil {
    public static Connection getConnection() {
        Connection conn=null;
        try {
            // 注册驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 链接
            conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Tutoral", "sa", "Sa123456");

        } catch (Exception e) {

        } finally {

        }
        return conn;
    }
}

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Connection conn = MyDataSouceHelper.getConnection();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(conn);
        }
        System.out.println("===========================");
        for (int i = 0; i < 5; i++) {
            Connection conn = MyDataSouceHelper.getConnection();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(conn);
        }
    }
}

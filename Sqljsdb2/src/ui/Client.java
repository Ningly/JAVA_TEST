package ui;

import java.sql.*;

public class Client {
    @SuppressWarnings("all")
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 加载与注册JDBC驱动
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2. 得到连接
        Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Tutoral", "sa", "Sa123456");
        Statement  statement= conn.createStatement();
        ResultSet set=statement.executeQuery("select * from Students");
        while (set.next()){
            System.out.println(set.getString(1));
        }
        set.close();
        statement.close();
        conn.close();

    }
}

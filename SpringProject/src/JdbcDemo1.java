import java.sql.*;

public class JdbcDemo1 {
    /*
    * 开发中遵守的原则：
    *   编译时不依赖，运行时依赖
    * 解决依赖关系:
    *   使用发射创建类对象
    * 使用反射创建类对象引发的新问题：
    *   使用配置文件，通过读取配置文件来反射创建类对象
    * */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1. 注册驱动
//        DriverManager.registerDriver(new SQLServerDriver());
        
        Class cla=Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        DriverManager.registerDriver((Driver) cla.newInstance());
        
        //2. 获取连接
        Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Tutoral","sa","Sa123456");
        //3. 获取操作数据库的与处理对象
        PreparedStatement pstm=conn.prepareStatement("select * from Students");
        //4. 执行sql语句并获取返回结果
        ResultSet resultSet=pstm.executeQuery();
        // 5. 封装结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("FirstName"));
        }
        // 6. 释放资源
        resultSet.close();
        pstm.close();
        conn.close();
    }
}

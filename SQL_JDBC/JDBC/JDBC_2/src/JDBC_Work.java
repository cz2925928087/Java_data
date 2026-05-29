import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.xdevapi.Result;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Work {
    public static void main(String[] args) throws SQLException {
        // 1 创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/class?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Cz.200406146737");

        //2 与数据库服务器建立连接
        Connection connection = dataSource.getConnection();

        //3 构造sql语句
        String sql = "insert into student values(null,'张三'),(null,'李四'),(null,'王五')";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        String sql1 = "select *from student";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        //4 执行sql语句
        int n = preparedStatement.executeUpdate();
        System.out.println(n);

        ResultSet resultSet = preparedStatement1.executeQuery();
        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            System.out.println(ID+" "+name);
        }

        //5 关闭资源
        resultSet.close();
        preparedStatement1.close();
        preparedStatement.close();
        connection.close();
    }
}

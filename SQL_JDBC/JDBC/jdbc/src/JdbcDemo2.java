import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

// 基于JDBC查询
public class JdbcDemo2 {

    public static void main(String[] args) throws SQLException {
        //创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/class?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Cz.200406146737");

        //和数据库服务器进行连接
        Connection connection = dataSource.getConnection();

        //构造sql语句
        String sql = "select *from student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //执行sql
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            System.out.println(ID + " " + name);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}

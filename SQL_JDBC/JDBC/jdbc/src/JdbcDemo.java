import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //MysqlDataSource mysqlDataSource = new MysqlXADataSource();
        //mysqlDataSource.setURL();
        //1 创建数据源(DataSource)对象
        DataSource dataSource = new MysqlDataSource();//向上转型:将子类对象转换为父类对象的过程。
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/class?characterEncoding=utf8&useSSL=false");//向下转型:父类对象强转为子类过程
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Cz.200406146737");

        //2 和数据库服务器进行通信,建立网络连接
        Connection connection =  dataSource.getConnection();

        //3 构造sql语句
        //请输入ID
        System.out.println("请输入ID ");
        int ID = scanner.nextInt();
        System.out.println(ID);
        System.out.println("请输入姓名 ");
        String name = scanner.next();
        System.out.println(name);
        String sql = "insert into student values(?,?)";
        //预编译语句,客户端先进行编译解析,解析完后再传给服务器
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, ID);
        preparedStatement.setString(2, name);

        //4 执行sql(把sql通过网络发送到服务器)
        /*该方法用于进行"增删改,建表删表"这些操作
          返回值是int类型,意思是该操作影响了几行
        * */
        //用于"查"的方法executeQuery()
        int n = preparedStatement.executeUpdate();
        System.out.println("n = "+ n);

        //5 关闭连接等资源
        preparedStatement.close();
        connection.close();
        scanner.close();
    }
}

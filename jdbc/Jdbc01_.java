package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

@SuppressWarnings("all")
public class Jdbc01_ {
	public static void main(String[] args) throws SQLException {

		Driver driver = new Driver();

		String url = "jdbc:mysql://127.0.0.1:3306/db01";
		String user = "root";
		String password = "123456";

		Properties prop = new Properties();
		prop.setProperty("user", user);
		prop.setProperty("password", password);

		Connection connect = driver.connect(url, prop);
//		Connection connect = DriverManager.getConnection(url, user, password);

		String sql = "insert into actor values(null,'刘德华','男','1970-11-11','110')";

		Statement statement = connect.createStatement();

		int rows = statement.executeUpdate(sql);

		System.out.println(rows > 0 ? "成功" : "失败");

		statement.close();
		connect.close();

	}
}

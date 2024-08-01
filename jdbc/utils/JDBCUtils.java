package jdbc.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 定义工具类，完成mysql的连接和关闭资源
 */
public class JDBCUtils {

	private static String user;
	private static String password;
	private static String url;
	private static String driver;

	static {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/mysql.properties"));

			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			driver = prop.getProperty("driver");
			
			Class.forName(driver);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void close(ResultSet set, Statement statement, Connection connection) {

		try {

			if (set != null) {
				set.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.mysql.jdbc.Driver;

/**
 * 连接数据库的方式
 */
public class Jdbc02_ {
	public static void main(String[] args) {

	}

	public void connnect01() throws SQLException {
		Driver driver = new Driver();

		String url = "jdbc:mysql://127.0.0.1:3306/db01";
		String user = "root";
		String password = "123456";

		Properties prop = new Properties();
		prop.setProperty("user", user);
		prop.setProperty("password", password);

		Connection connect = driver.connect(url, prop);
		connect.close();

	}

	@SuppressWarnings("deprecation")
	public void connnect02()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) aClass.newInstance();

		String url = "jdbc:mysql://127.0.0.1:3306/db01";
		String user = "root";
		String password = "123456";

		Properties prop = new Properties();
		prop.setProperty("user", user);
		prop.setProperty("password", password);

		Connection connect = driver.connect(url, prop);
		connect.close();

	}

	@SuppressWarnings("deprecation")
	public void connnect03()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) aClass.newInstance();

		String url = "jdbc:mysql://127.0.0.1:3306/db01";
		String user = "root";
		String password = "123456";

		DriverManager.registerDriver(driver);
		Connection connect = DriverManager.getConnection(url, user, password);

		connect.close();

	}

	public void connnect04()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		// 这句话可以省略
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://127.0.0.1:3306/db01";
		String user = "root";
		String password = "123456";

		Connection connect = DriverManager.getConnection(url, user, password);

		connect.close();

	}
	
	public void connnect05()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/mysql.properties"));
		
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String driver = prop.getProperty("driver");


		// 这句话可以省略
		Class.forName(driver);

		Connection connect = DriverManager.getConnection(url, user, password);

		connect.close();
		

	}

}

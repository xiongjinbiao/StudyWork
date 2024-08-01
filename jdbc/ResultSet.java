package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * select查询的返回结果集resultSet
 */
public class ResultSet {
	public static void main(String[] args) throws Exception {

		Properties prop = new Properties();
		prop.load(new FileInputStream("src/mysql.properties"));

		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String driver = prop.getProperty("driver");

		// 这句话可以省略
		Class.forName(driver);

		Connection connect = DriverManager.getConnection(url, user, password);

		Statement statement = connect.createStatement();

		String sql = "select id,name,sex,borndate from actor";

		java.sql.ResultSet res = statement.executeQuery(sql);

		while (res.next()) {
			int id = res.getInt(1);
			String name = res.getString(2);
			String sex = res.getString(3);
			String borndate = res.getString(4);
			System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate);
		}

		connect.close();

	}
}

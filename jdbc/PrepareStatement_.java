package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * 演示prepareStatement 防止SQL注入
 */
public class PrepareStatement_ {
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
		
		// select语句使用executeQuery
		// dml语句使用executeUpdate

//		String sql = "select id, name, sex, borndate from actor where id =? and name =?";

		String insertSql = "insert into db01.actor values(null,'鸡哥','男','1973-11-11',?)";

		PreparedStatement preparedStatement = connect.prepareStatement(insertSql);

//		preparedStatement.setInt(1, 2);
//		preparedStatement.setString(2, "刘亦菲");

		preparedStatement.setString(1, "114");

		java.sql.ResultSet res = preparedStatement.executeQuery();

		while (res.next()) {
			// 1 通过字段顺序获取 2 通过字段名获取
			int id = res.getInt(1);
//			int id = res.getInt("id");
			String name = res.getString(2);
			String sex = res.getString(3);
			String borndate = res.getString(4);
			System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate);
		}

		int row = preparedStatement.executeUpdate();
		System.out.println(row > 0 ? "success" : "fail");

		res.close();
		preparedStatement.close();
		connect.close();

	}
}

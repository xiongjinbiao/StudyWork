package jdbc.utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtilsByDruid {

	private static DataSource ds;

	static {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws Exception {
		return ds.getConnection();
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

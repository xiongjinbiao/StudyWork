package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.utils.JDBCUtils;

public class JDBCUtilsUse {

	public void testDML() {

		Connection connection = null;
		PreparedStatement statement = null;

		String insertSql = "insert into db01.actor values(null,'蔡徐坤','男','1973-11-11',?)";

		try {
			connection = JDBCUtils.getConnection();
			statement = connection.prepareStatement(insertSql);
			statement.setString(1, "145");
			int row = statement.executeUpdate();
			System.out.println(row > 0 ? "success" : "fail");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCUtils.close(null, statement, connection);


	}

	public void testQuery() {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		String selectSql = "select id, name, sex, borndate from actor";

		try {
			connection = JDBCUtils.getConnection();
			statement = connection.prepareStatement(selectSql);
			set = statement.executeQuery();

			while (set.next()) {

				int id = set.getInt("id");
				String name = set.getString("name");
				String sex = set.getString("sex");
				String borndate = set.getString("borndateF");
				System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtils.close(null, statement, connection);

	}

}

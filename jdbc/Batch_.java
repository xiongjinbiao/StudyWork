package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.utils.JDBCUtils;

/**
 * 演示java的批处理
 * 注意url后面必须接 ?rewriteBatchStatements=true
 * url=jdbc:mysql://127.0.0.1:3306/db01?rewriteBatchStatements=true
 */
public class Batch_ {
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		String insertSql = "insert into db01.admin values(null, ?, ?)";

		try {
			connection = JDBCUtils.getConnection();
			statement = connection.prepareStatement(insertSql);

			for (int i = 0; i < 5000; i++) {
				
				statement.setString(1, "jack" + i);
				statement.setString(2, "666" + i);
				statement.addBatch();
				
				// 1000条sql执行一次
				if ((i + 1) % 1000 == 0) {
					
					// 批执行
					statement.executeBatch();
					// 清空批处理池
					statement.clearBatch();
					
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtils.close(null, statement, connection);

	}
}

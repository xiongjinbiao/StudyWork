package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.utils.JDBCUtils;

/**
 * 演示事务，转账案例
 */
public class Transaction_ {
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		String updateSql1 = "update db01.account set balance = balance - 100 where id = 1";
		String updateSql2 = "update db01.account set balance = balance + 100 where id = 2";

		try {
			connection = JDBCUtils.getConnection();

			// 设置自动提交为false
			connection.setAutoCommit(false);

			statement = connection.prepareStatement(updateSql1);
			statement.executeUpdate();

			// 模拟异常，让数据进行回滚
//			int i = 1 / 0;

			statement = connection.prepareStatement(updateSql2);
			statement.executeUpdate();
			
			// 事务提交
			connection.commit();

		} catch (SQLException e) {

			// 发生异常，直接回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		}

		JDBCUtils.close(null, statement, connection);

	}
}

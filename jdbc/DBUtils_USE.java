package jdbc;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import jdbc.utils.JDBCUtilsByDruid;

public class DBUtils_USE {

	/**
	 * 当返回结果是多行多列
	 */
	public void testQueryMulti() throws Exception {

		Connection connection = JDBCUtilsByDruid.getConnection();

		QueryRunner queryRunner = new QueryRunner();

		String sql = "select * from actor where id > ?";
		// 当返回结果是多行多列
		List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);

		for (Actor actor : list) {
			System.out.println(actor);
		}

		JDBCUtilsByDruid.close(null, null, connection);

	}

	/**
	 * 当返回结果是单行多列
	 */
	public void testQuerySingle() throws Exception {

		Connection connection = JDBCUtilsByDruid.getConnection();

		QueryRunner queryRunner = new QueryRunner();

		String sql = "select * from actor where id = ?";
		// 当返回结果是单行多列
		Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);

		System.out.println(actor);

		JDBCUtilsByDruid.close(null, null, connection);

	}

	/**
	 * 当返回结果是单行单列
	 */
	public void testQueryScalar() throws Exception {

		Connection connection = JDBCUtilsByDruid.getConnection();

		QueryRunner queryRunner = new QueryRunner();

		String sql = "select name from actor where id = ?";
		// 当返回结果是单行多列
		Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 1);

		System.out.println(obj);

		JDBCUtilsByDruid.close(null, null, connection);

	}

	/**
	 * 演示DML(update, insert, delete)
	 */
	public void testDML() throws Exception {

		Connection connection = JDBCUtilsByDruid.getConnection();

		QueryRunner queryRunner = new QueryRunner();

		String sql = "update actor set name = ? where id = ?";
//		String sql = "delete from actor where id = ?";
//		String sql = "insert into actor values(null, ?, ?, ?, ?)";

		int affectedRows = queryRunner.update(connection, sql, "林志颖", 4);

		System.out.println(affectedRows > 0 ? "success" : "fail");

		JDBCUtilsByDruid.close(null, null, connection);

	}

}

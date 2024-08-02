package mhl.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import mhl.utils.JDBCUtilsByDruid;

/**
 * 数据库基本操作(curd)父类
 * @param <T>
 */
public class BasicDAO<T> {

	private QueryRunner qr = new QueryRunner();

	public int update(String sql, Object... parameters) {

		Connection connection = null;

		try {

			connection = JDBCUtilsByDruid.getConnection();
			int update = qr.update(connection, sql, parameters);
			return update;

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			JDBCUtilsByDruid.close(null, null, connection);
		}

	}

	
	public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {

		Connection connection = null;

		try {

			connection = JDBCUtilsByDruid.getConnection();
			List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
			return query;

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			JDBCUtilsByDruid.close(null, null, connection);
		}

	}

	public T querySingle(String sql, Class<T> clazz, Object... parameters) {

		Connection connection = null;

		try {

			connection = JDBCUtilsByDruid.getConnection();
			T query = qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
			return query;

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			JDBCUtilsByDruid.close(null, null, connection);
		}

	}

	public Object queryScalar(String sql, Object... parameters) {

		Connection connection = null;

		try {

			connection = JDBCUtilsByDruid.getConnection();
			Object query = qr.query(connection, sql, new ScalarHandler(), parameters);
			return query;

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			JDBCUtilsByDruid.close(null, null, connection);
		}

	}

}

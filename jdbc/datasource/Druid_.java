package jdbc.datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;



public class Druid_ {

	@Test
	public void testDruid_01() throws Exception {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/druid.properties"));
		
		DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
		
		Connection connection = dataSource.getConnection();
		
		System.out.println("connect success ...");
		
		connection.close();
		
	}
	
}

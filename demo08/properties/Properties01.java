package demo08.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties01 {
	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		prop.load(new FileReader("src/mysql2.properties"));
		
		// 读取
		String ip = prop.getProperty("ip");
		String user = prop.getProperty("user");
		String pwd = prop.getProperty("pwd");

		System.out.println(ip);
		System.out.println(user);
		System.out.println(pwd);
		
	}
}

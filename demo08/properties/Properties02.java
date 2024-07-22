package demo08.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class Properties02 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException {

		Properties prop = new Properties();
		prop.setProperty("ip", "192.168.11.2");
		prop.setProperty("user", "xiong");
		prop.setProperty("pwd", "123");

		prop.save(new FileOutputStream("src/mysql2.properties"), null);
		
	}
}

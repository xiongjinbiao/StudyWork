package demo10.reflection;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {

	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

//		Cat cat = new Cat();
//		System.out.println(cat.getClass());

		Properties prop = new Properties();
		prop.load(new FileReader("src/re.properties"));
		String className = prop.getProperty("className");
		String methodName = prop.getProperty("methodName");

		Class cls = Class.forName(className);
		Object obj = cls.newInstance();
		
		// 调用方法
		Method method = cls.getMethod(methodName);
		method.invoke(obj, args);

		// 调用字段
		Field field = cls.getField("age");
		System.out.println("age " + field.get(obj));
		
		// 调用构造器
		Constructor constructor01 = cls.getConstructor();
		System.out.println("constructor01 " + constructor01);
		
		Constructor constructor02 = cls.getConstructor(String.class);
		System.out.println("constructor02 " + constructor02);

		
	}

}

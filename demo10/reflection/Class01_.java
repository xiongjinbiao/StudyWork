package demo10.reflection;

import java.lang.reflect.Field;

/**
 * 演示Class类的方法
 */
public class Class01_ {
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		String classPath = "demo10.reflection.Cat";
		Class<?> cls = Class.forName(classPath);

		System.out.println(cls);
		System.out.println(cls.getClass());

		// 包名
		System.out.println(cls.getPackage().getName());
		
		// 全类名
		System.out.println(cls.getName());
		
		Object o = cls.newInstance();
		
		System.out.println(o);
		
		// 获取字段
		Field age = cls.getField("age");
	
		// 赋值
		age.setInt(o, 2);
		System.out.println(age.get(o));
		
		// 获取素有能获取的字段
		Field[] fields = cls.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field.get(o));
		}

	}
}

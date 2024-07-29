package demo10.reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 反射是动态加载，即逻辑走到代码块时候才会编译 否则不会编译，即依赖性较弱
 */
public class Class02_ {
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String key = sc.next();

		switch (key) {
		// 当key不为1时候，代码就不会走到下方逻辑
		// 因为demo10.reflection.Dog是通过反射调用的，不会加载该类
		// 所以即使没有demo10.reflection.Dog这个类，执行时候仍不会报错
		case "1":
			Class<?> cls = Class.forName("demo10.reflection.Dog");
			Object o = cls.newInstance();
			Method m = cls.getMethod("hi");
			m.invoke(o);
			break;
		case "2":
			System.out.println("ok");
			break;
		default:
			System.out.println("no this key");
		}

	}
}

package demo05.innerClass;

// 匿名内部类
public class InnerClass02 { // 外部其他类
	public static void main(String[] args) {

		Outer01 outer = new Outer01();
		outer.method();

	}
}

class Outer01 { // 外部类（外部类无法访问匿名内部类的成员）

	private int n1 = 100;

	public void method() {

		A tiger = new A() { // 基于接口匿名内部类（系统会赋予一个类名，Outer01$1）
			// 本来接口A是不可以被实例化，但是可以后接大括号实现接口A的方法
			// 当调用时候系统底层会根据这个语法去实现一次，用完即关闭，简化开发
			public void cry() {
				System.out.println("n1 = " + n1);
				System.out.println("tiger is crying");
			}
		};
		tiger.cry();
		System.out.println(tiger.getClass()); // Outer01$1

		Father father = new Father("jack") { // 基于类的匿名内部类（系统会赋予一个类名，Outer01$2）

			public void test() {
				System.out.println("基于类的匿名内部类实现了test()");
			}

		};
		father.test();
		System.out.println(father.getClass()); // Outer01$2

	}

	interface A {
		public void cry();
	}

	class Father {

		public Father(String name) {
		}

		public void test() {

		}

	}

}
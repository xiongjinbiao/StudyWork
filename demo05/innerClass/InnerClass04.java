package demo05.innerClass;

// 静态内部类
public class InnerClass04 { // 外部其他类
	public static void main(String[] args) {

		Outer03 outer = new Outer03();
		outer.new Inner03().f1();

	}
}

class Outer04 { // 外部类（外部类直接创建内部类对象，进而访问内部类的成员）

	private static int n1 = 100;

	public static void m2() {
		System.out.println("Outer m2()");
	}

	static class Inner04 { // 静态内部类，访问方式与static的用法一致
		// static只能访问static成员，非staic都可以访问 
		// 前提都是满足访问修饰符权限
		// 当内部类和外部类有相同名字的成员时候，可以通过 Outer. 访问外部类的成员来进行区分，注意不需要this
		private int n1 = 800;

		public void f1() {
			System.out.println("inner.n1 = " + n1);
			System.out.println("outer.n1 = " + Outer04.n1);
			Outer04.m2();
		}
	}

}
package demo05.innerClass;

// 局部内部类
public class InnerClass01 { // 外部其他类
	public static void main(String[] args) {

		Outer outer = new Outer();
		outer.m1();

	}
}

class Outer { // 外部类（外部类直接创建内部类对象，进而访问内部类的成员）

	private int n1 = 100;

	public void m2() {
		System.out.println("Outer m2()");
	}

	public void m1() {

		final class Inner { // 局部内部类，通常定义在外部类的方法体或者代码块中，作用域在方法块中
			// 当内部类和外部类有相同名字的成员时候，可以通过 Outer.this. 访问外部类的成员来进行区分
			private int n1 = 800;

			public void f1() {
				System.out.println("inner.n1 = " + n1);
				System.out.println("outer.n1 = " + Outer.this.n1);
				Outer.this.m2();
			}
		}

		Inner inner = new Inner();
		inner.f1();

	}

}
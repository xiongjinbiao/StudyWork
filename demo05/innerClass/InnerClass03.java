package demo05.innerClass;

// 成员内部类
public class InnerClass03 { // 外部其他类
	public static void main(String[] args) {

		Outer03 outer = new Outer03();
		outer.new Inner03().f1();

	}
}

class Outer03 { // 外部类（外部类直接创建内部类对象，进而访问内部类的成员）

	private int n1 = 100;

	public void m2() {
		System.out.println("Outer m2()");
	}

	class Inner03 { // 成员内部类，可以把Inner03理解为Outer03类的一个成员，用的时候直接 new 实例化
		// 当内部类和外部类有相同名字的成员时候，可以通过 Outer.this. 访问外部类的成员来进行区分
		private int n1 = 800;

		public void f1() {
			System.out.println("inner.n1 = " + n1);
			System.out.println("outer.n1 = " + Outer03.this.n1);
			Outer03.this.m2();
		}
	}

}
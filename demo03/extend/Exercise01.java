package demo03.extend;

public class Exercise01 {
	public static void main(String[] args) {
		B b1 = new B();  //调的是B的无参构造器  a ; b name; b
		B b = new B("abxbfd");  // 调的是B的有参构造器  a ; b name
	}
}

class A {

	A() {
		System.out.println("a");
	}

	A(String name) {
		System.out.println("a name");
	}

}

class B extends A {

	B() {
		this("abc");// 因为这里有一个this，因此默认的super无效（同一个构造器中super和this只能存在一个）
		System.out.println("b");
	}

	B(String name) {
		// super(); //子类中默认有一个super(); 继承父类的无参构造器
		System.out.println("b name");
	}

}
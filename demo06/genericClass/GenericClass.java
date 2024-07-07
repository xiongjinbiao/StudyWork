package demo06.genericClass;

// 范型类
public class GenericClass {
	public static void main(String[] args) {

	}
}

// 创建类时候 T R M 默认是object类型
// 只有在创建对象时候可以赋与类型
class Tiger<T, R, M> {

	String name;
	M m;
	T t;
	R r;

	public Tiger(String name, M m, T t, R r) {
		super();
		this.name = name;
		this.m = m;
		this.t = t;
		this.r = r;
	}

	// 使用范型的话，不管是静态方法还是静态变量，都不允许static
//F	static R r;
//F	public static void m1 (M m) {}

	public void m1(M m) {
	}

}
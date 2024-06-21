package demo03;


public class ThisDetail{
	public static void main(String[] args) {
		
		T1 t= new T1();
		System.out.println(t.name);
		
	}
}

// this关键字只能在类中使用
class T1{
	
	String name;
	int age;

	public T1() {
		// 通过this关键字调用其他构造器（第三个）（并且只能写在第一行，并且只能调用一个）
		this("jack");
		System.out.println("T构造器");
	} 

	public T1(String name, int age) {
		// 通过this关键字解决构造器参数和属性一致问题，this指定的是属性
		this.name = name;
		this.age = age;
		System.out.println("T(String name, int age)构造器");
	}

	public T1(String name) {
		this.name = name;
	}
	
}
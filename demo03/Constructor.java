package demo03;

public class Constructor {
	public static void main(String[] args) {

		Person p1 = new Person("pipi", 2);
		System.out.println("p1信息，姓名 " + p1.name + " 年龄 " + p1.age);
		Person p2 = new Person("huahua");
		System.out.println("p2信息，姓名 " + p2.name);

	}
}

class Person {

	String name;
	int age;

	// 构造器也可以写多个，即构造器重载
	// 系统会默认一个无参构造器
	// 当定义了自己的构造器，默认的无参构造器必须自己写出来，否则无参构造器无法被使用
	Person() {
	} // 无参构造器

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name) {
		this.name = name;
	}

}
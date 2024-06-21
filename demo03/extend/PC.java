package demo03.extend;

/**
 * super && this
 * 
引用对象:
this 引用当前对象的实例。
super 引用当前对象的父类部分。
用途:
this 用于当前类的实例变量、方法和构造方法。
super 用于父类的构造方法、方法和成员变量。
构造方法:
this 可以在一个构造方法中调用另一个构造方法，但必须是同一个类内的。
super 用于在子类构造方法中调用父类的构造方法，必须在构造方法的第一行。

 * 1，super只 访问父类的方法，属性，构造器（除了private访问修饰符）
 * 2，super只找父类及父类以上类（一级一级的找，直到object类），并且遵循就近原则（前提还要遵循访问修饰符的原则），找不到就报错
 * 3，this优先寻找本类，再去寻找父类及父类以上类（一级一级的找，直到object类），并且遵循就近原则（前提还要遵循访问修饰符的原则），找不到就报错
 */

public class PC extends Computer {

	private String brand;

	public PC() {
		super();
	}

	public PC(String cpu, int memory, int disk, String brand) {
		super(cpu, memory, disk);
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void printInfo() {
		System.out.println("PC信息\n" + super.getDetails() + ", brand=" + brand);
	}
	
	// public -> protected -> 默认 -> private
	// 重写方法的访问修饰符必须 >= 父类的方法访问修饰符
	public String getDetails() {
		return null;
	}

}
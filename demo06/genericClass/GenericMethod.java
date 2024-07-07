package demo06.genericClass;

// 范型方法
public class GenericMethod {
	public static void main(String[] args) {

		Child child = new Child();
		child.run(3); //此时I是Integer
		child.run("sadas"); //此时I是String

	}
}

class Child { // 普通类

	public void eat() {
	}; // 普通方法

	public <I> void run(I i) {
		System.out.println(i.getClass().getSimpleName());
	}; // 范型方法

}
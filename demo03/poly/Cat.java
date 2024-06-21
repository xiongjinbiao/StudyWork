package demo03.poly;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	public void catchMouse() {
		System.out.println(super.getName() + "会抓老鼠");
	}

}
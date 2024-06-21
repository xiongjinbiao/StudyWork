package demo03.poly;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	public void stayHome() {
		System.out.println(super.getName() + "会看家");
	}

}
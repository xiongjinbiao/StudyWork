package demo05;

public class HomeWork {
	public static void main(String[] args) {
		Person p = new Person("tangseng");
		p.passRiver();
		p.common();
		p.passRiver();
	}
}

interface V {
	void work();
}

class Boat implements V {

	@Override
	public void work() {
		System.out.println("过河情况下用船");
	}

}

class Horse implements V {

	@Override
	public void work() {
		System.out.println("一般情况下用马");
	}

}

class Person{
	private V v;
	private String name;
	
	public Person(String name) {
		setName(name);
	}

	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void passRiver() {
		VF.getBoat().work();
	}
	
	public void common() {
		VF.getHorse().work();
	}
	
}

class VF{
	public static Boat getBoat() {
		return new Boat();
	}
	public static Horse getHorse() {
		return new Horse();
	}
}
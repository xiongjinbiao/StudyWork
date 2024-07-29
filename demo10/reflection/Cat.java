package demo10.reflection;

public class Cat {

	private String name = "招财猫";
	
	public int age = 1;
	
	public String color = "yellow";
	
	public Cat(){
		
	}
	
	public Cat(String name) {
		
	}

	public void hi() {
		System.out.println("hi " + name);
	}

	public void cry() {
		System.out.println(name + " cry");
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
	

}

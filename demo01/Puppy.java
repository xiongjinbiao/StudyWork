package demo01;

public class Puppy {
	
	private int puppyAge;
	
	public Puppy(String name) {
		System.out.println("小狗的名字是 " + name);
	}
	
	public int getPuppyAge() {
		return puppyAge;
	}
	public void setPuppyAge(int puppyAge) {
		System.out.println("小狗年龄 " + puppyAge);
		this.puppyAge = puppyAge;
	}
	
	public static void main(String[] args) {
		Puppy myPuppy = new Puppy("pipi");
		myPuppy.setPuppyAge(2);
		myPuppy.getPuppyAge();
		System.out.println("变量值 " + myPuppy.puppyAge);
	} 
	
}
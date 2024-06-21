package demo03.polyArr;

public class Teacher extends Person {

	private int salary;

	public Teacher() {
		super();
	}

	public Teacher(String name, int age, int salary) {
		super(name, age);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String showInfo() {
		return "teacher " + super.showInfo() + ", salary=" + salary;
	}

	public String teach() {
		return super.getName() + "正在教学java 。。。";
	}

}
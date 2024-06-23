package demo03.polyParameter;

public class Worker extends Employee {

	public Worker() {
		super();
	}

	public Worker(String name, double salary) {
		super(name, salary);
	}

	public double getAnnual() {
		return super.getAnnual();
	}

	public void work() {
		System.out.println(super.getName() + " is working");
	}

}
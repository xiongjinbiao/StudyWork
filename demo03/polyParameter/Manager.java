package demo03.polyParameter;

public class Manager extends Employee {

	private double bouns;

	public Manager() {
		super();
	}

	public Manager(String name, double salary, double bouns) {
		super(name, salary);
		setBouns(bouns);
	}

	public double getBouns() {
		return bouns;
	}

	public void setBouns(double bouns) {
		this.bouns = bouns;
	}

	public double getAnnual() {
		return super.getAnnual() + getBouns();
	}

	public void manage() {
		System.out.println(super.getName() + "is managing");
	}

}
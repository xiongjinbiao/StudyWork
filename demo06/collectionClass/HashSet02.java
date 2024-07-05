package demo06.collectionClass;

import java.util.HashSet;
import java.util.Objects;

public class HashSet02 {
	public static void main(String[] args) {

		HashSet<Employee> set = new HashSet<Employee>();
		set.add(new Employee("jack",18));
		set.add(new Employee("jack",23));
		set.add(new Employee("milan",18));

		System.out.println(set);
			
	}
}

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	
	// 重写hashCode的equals方法，当name和age都相同时候才会进行去重操作
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && Objects.equals(name, other.name);
	}


}
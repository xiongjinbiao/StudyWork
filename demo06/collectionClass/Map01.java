package demo06.collectionClass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Map01 {
	public static void main(String[] args) {

		HashMap<Integer,Emp> hashMap = new HashMap<Integer, Emp>();
		
		hashMap.put(1, new Emp(1,"xjb",19000));
		hashMap.put(2, new Emp(2,"lili",17000));
		hashMap.put(3, new Emp(3,"dmm",29000));
		
		Set<Integer> keySet = hashMap.keySet();		
		
		for (Object key : keySet) {
			Emp emp = hashMap.get(key);
			if(emp.getSalary() > 18000) {
				System.out.println(emp);
			}
		}
		
		Set<Entry<Integer,Emp>> entrySet = hashMap.entrySet();
		for (Entry<Integer, Emp> entry : entrySet) {
			Emp value = entry.getValue();
			if(value.getSalary() > 18000) {
				System.out.println(value);
			}
		}
		
	}
}


class Emp{
	
	private int id;
	private String name;
	private double salary;
	
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	
}
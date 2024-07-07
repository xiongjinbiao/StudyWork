package demo06.genericClass;

import java.util.ArrayList;
import java.util.Comparator;

public class Gengeric01 {
	public static void main(String[] args) {

		ArrayList<Person> arrayList = new ArrayList<Person>();
		arrayList.add(new Person("tom", 20000, new MyDate(1999, 2, 5)));
		arrayList.add(new Person("tom", 20000, new MyDate(1999, 2, 4)));
		arrayList.add(new Person("jack", 20000, new MyDate(1999, 1, 5)));
		arrayList.add(new Person("smith", 20000, new MyDate(1999, 1, 4)));

		System.out.println(arrayList);

		arrayList.sort(new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {

				int nameMinus = p1.getName().compareTo(p2.getName());
				if (nameMinus != 0) {
					return nameMinus;
				}
				
				return MyDate.compare(p1.getBirthday(),p2.getBirthday());
//				return p1.getBirthday().compareTo(p2.getBirthday());
				
			}

		});
		System.out.println("===排序后===");
		System.out.println(arrayList);

	}
}

class Person {

	private String name;
	private double salary;
	private MyDate birthday;

	public Person(String name, double salary, MyDate birthday) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
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

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "\nPerson [name=" + name + ", salary=" + salary + ", birthday=" + birthday + "]";
	}

}

class MyDate implements Comparable<MyDate> {
	private int year;
	private int mon;
	private int day;
	
	public MyDate(int year, int mon, int day) {
		super();
		this.year = year;
		this.mon = mon;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMon() {
		return mon;
	}

	public void setMon(int mon) {
		this.mon = mon;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "MyDate [year=" + year + ", mon=" + mon + ", day=" + day + "]";
	}

	public static int compare(MyDate m1, MyDate m2) {
		int yearMinus = m1.getYear() - m2.getYear();
		if (yearMinus != 0) {
			return yearMinus;
		}

		int monMinus = m1.getMon() - m2.getMon();
		if (monMinus != 0) {
			return monMinus;
		}else {
			
		}
		return m1.getDay() - m2.getDay();
	}

	@Override
	public int compareTo(MyDate m2) {
		int yearMinus = this.year - m2.getYear();
		if (yearMinus != 0) {
			return yearMinus;
		}

		int monMinus = this.mon - m2.getMon();
		if (monMinus != 0) {
			return monMinus;
		}
		return this.day - m2.getDay();
	}

}
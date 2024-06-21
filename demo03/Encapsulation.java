package demo03;

// 封装
public class Encapsulation {
	public static void main(String[] args) {

//		Persons person = new Persons();
//		person.setName("jack");
//		person.setAge(121);
//		person.setSalary(13000);
//		System.out.println(person.info());

		// 使用构造器联合set方法，得到的结果与上面一致
		Persons person1 = new Persons("jack", 121, 13000);
		System.out.println(person1.info());

	}
}

class Persons {

	public String name;
	private int age;
	private double salary;

	public Persons() {
	}

	public Persons(String name, int age, double salary) {
		// 构造器联合set方法使用，对输入数据进行校验（）
		this.setName(name);
		this.setAge(age);
		this.setSalary(salary);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// 加入数据的校验
		if (name.length() >= 2 && name.length() <= 6) {
			this.name = name;
		} else {
			System.out.println("输入名字长度2-6，默认给null");
			this.name = null;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		// 判断
		if (age >= 1 && age <= 120) {
			this.age = age;
		} else {
			System.out.println("输入年龄超出1-120，默认给18");
			this.age = 18;
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String info() {
		return "Person [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}
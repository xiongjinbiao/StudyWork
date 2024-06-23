package demo03.polyArr;

// 多态数组
public class PolyArr {
	public static void main(String[] args) {

		Person[] persons = new Person[5];
		persons[0] = new Person("jack", 20);
		persons[1] = new Student("tom", 16, 80);
		persons[2] = new Student("jerry", 17, 90);
		persons[3] = new Teacher("alise", 35, 15000);
		persons[4] = new Teacher("bob", 50, 25000);

		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i].showInfo());
			// instanceof 比较的是运行类型，也就是右半边的类型
			if (persons[i] instanceof Student) {
				System.out.println(((Student) persons[i]).study());
			} else if (persons[i] instanceof Teacher) {
				System.out.println(((Teacher) persons[i]).teach());
			} else if (persons[i] instanceof Person) {
				System.out.println(persons[i].sing());
			} else {
				System.out.println("输入类型有误");
			}
		}

	}
}
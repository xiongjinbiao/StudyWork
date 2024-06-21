package demo03;

public class Object {
	public static void main(String[] args) {

		Cat cat1 = new Cat();
		cat1.name = "huahua";
		cat1.age = 2;
		cat1.color = "yellow";

		Cat cat2 = new Cat();
		cat2.name = "jinjin";
		cat2.age = 3;
		cat2.color = "black";

		System.out.println("cat1的信息，姓名 " + cat1.name + "，年龄 " + cat1.age + "，颜色 " + cat1.color);
		System.out.println("cat2的信息，姓名 " + cat2.name + "，年龄 " + cat2.age + "，颜色 " + cat2.color);

		cat1.speak();
		cat1.cal(5);
		System.out.println(cat1.getSum(1, 2));

	}
}

class Cat {

	// 属性 / 对象 / field（字段）
	String name;
	int age;
	String color;

	// 方法 / 函数
	public void speak() {
		System.out.println("miao miao miao");
	}

	public void cal(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += i;
		}
		System.out.println("sum = " + sum);
	}

	public int getSum(int a, int b) {
		int res = a + b;
		return res;
	}

}
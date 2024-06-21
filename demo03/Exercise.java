package demo03;

public class Exercise {
	public static void main(String[] args) {

		MyTools mytools = new MyTools();
		double[] arr = { 1.2, 2.1, 3.2, 4.1 };
//		System.out.println(mytools.getMax(arr));
		
		PassObject p = new PassObject();
		Circle c2 = new Circle();
		p.printAreas(c2, 5);

	}
}

class MyTools {

	public Double getMax(double[] arr) {
		if (arr != null && arr.length > 0) {
			double max = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			return max;
		} else {
			return null;
		}
	}

	public int find(String str, String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			if (str.equals(strs[i]) && str.isEmpty() && strs.length > 0) {
				return i;
			}
		}
		return -1;
	}

}

class Book {

	String name;
	double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public void updatePrice() {
		if (this.price > 150) {
			this.price = 150;
		} else if (this.price > 100) {
			this.price = 100;
		}
	}

}

class Cale {

	double num1;
	double num2;

	public Cale(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public double add() {
		return num1 + num2;
	}

	public double del() {
		return num1 - num2;
	}

	public double mul() {
		return num1 * num2;
	}

	public Double div() {
		if (num2 != 0) {
			return num1 / num2;
		} else {
			return null;
		}
	}

}

class Music {

	String name;
	int times;

	public Music(String name, int times) {
		this.name = name;
		this.times = times;
	}

	public void play() {
		System.out.println(name + " is playing,times " + times);
	}

	public void info() {
		System.out.println("sing " + name + " times " + times);
	}

}

// 将对象变为参数传递给方法
class Circle{
	
	double radius;
	
	public double findArea() {
		return Math.PI * radius * radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}

class PassObject{
	
	public void printAreas(Circle c,int times) {
		System.out.println("radius\tarea");
		for(int i = 1;i<=times;i++) {
			c.setRadius(i);
			System.out.println(c.radius+"\t"+c.findArea());
		}
	}
	
}
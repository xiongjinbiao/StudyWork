package demo05;

public class HomeWork02 {
	public static void main(String[] args) {
		
		Car car = new Car(30);
		car.getAir().flow();
		
		Car car1 = new Car(-1);
		car1.getAir().flow();
		
	}
}

class Car {
	
	private double temp;

	public Car(double temp) {
		super();
		this.temp = temp;
	}

	
	class Air {
		
		public void flow() {
			if (temp > 20) {
				System.out.println("吹冷气");
			} else if (temp < 0) {
				System.out.println("吹热气");
			} else {
				System.out.println("关闭空调");
			}
		}
		
	}
	
	public Air getAir() {
		return new Air();
	}
	
	
}
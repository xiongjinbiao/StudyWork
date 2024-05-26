package demo01;

public class Circle {
	public static void main (String[] args) {
		
		int x = 10;
		int x1 = 10;;
		System.out.println("while");
		while(x < 13) {
			System.out.println("x的值 " + x);
			x++;
		}
		
		System.out.println("do while");
		do {
			System.out.println("x1的值 " + x1);
			x1++;
		} while(x1 < 13);
		
		for(int i = 10; i < 13; i++) {
			System.out.println("i的值 " + i);
		}
	
	}
}
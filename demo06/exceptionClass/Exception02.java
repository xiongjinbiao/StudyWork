package demo06.exceptionClass;

import java.util.Scanner;

@SuppressWarnings("all")
public class Exception02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while (true) {
			
			System.out.println("请输入一个整数");
			try {
				num = Integer.parseInt(sc.next());
				break;
			} catch (Exception e) {
				System.out.println("输入的不是一个整数");
			}

		}
		
		System.out.println("num = " + num);

	}
}

package demo02;

import java.util.Scanner;

public class ForExercise {
	public static void main(String[] args) {

//		double money = 100000d;
//		int count = 0;
//		while (true) {
//			if (money > 50000) {
//				money *= 0.95;
//				count ++;
//			} else if (money >= 1000) {
//				money -= 1000;
//				count++;
//			} else break;
//		}
//		System.out.println("可以过" + count + "个路口，还剩" + money);

		// 水仙花数
//		Scanner myScanner = new Scanner(System.in);
//		int num = myScanner.nextInt();
//		int n1 = num/100;
//		int n2 = num%100/10;
//		int n3 = num%10;
//		if (num == n1*n1*n1 + n2*n2*n2 + n3*n3*n3 ) {
//			System.out.println(num + "是水仙花数");
//		} else {
//			System.out.println(num + "不是水仙花数");
//		}

//		int count = 0;
//		for (int i = 1; i <= 100; i++) {
//			if (i % 5 != 0) {
//				count ++;
//				System.out.print(i + " ");
//			}
//			if (count % 5 == 0) {
//				System.out.println();
//			}
//		}

//		for (char c1 = 'a'; c1 <= 'z'; c1++) {
//			System.out.print(c1 + " ");
//		}
//		for (char c1 = 'Z'; c1 >= 'A'; c1--) {
//			System.out.print(c1 + " ");
//		}

//		double sum = 0d;
//		for (int i = 1; i <= 100; i++) {
//			if (i % 2 == 0) {
//				sum -= 1.0/i;
//			} else {
//				sum += 1.0/i;
//			}
//		}
//		System.out.println("sum= " + sum);

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= i; j++) {
				sum += j;
			}
		}
		System.out.println("sum= " + sum);

	}
}
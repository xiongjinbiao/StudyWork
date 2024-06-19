package demo02;

public class For {
	public static void main(String[] args) {
		
		//等腰三角
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 5 - i; j >= 0; j--) {
//				System.out.print(" ");
//			}
//			for (int j = 1; j <= 2*i-1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//直角
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 5 - i; j >= 0; j--) {
//				System.out.print(" ");
//			}
//			for (int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//菱形
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 5 - i; j >= 0; j--) {
//				System.out.print(" ");
//			}
//			for (int j = 1; j <= 2*i-1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for (int i = 4; i >= 0; i--) {
//			for (int j = 5 - i; j >= 0; j--) {
//				System.out.print(" ");
//			}
//			for (int j = 1; j <= 2*i-1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// 9 * 9乘法表
//		for (int i = 1; i < 10; i++) {
//			for (int j = 1; j <= i; j++) {
//				System.out.print(i+" * "+j+" = "+i*j+" ");
//			}
//			System.out.println();
//		}
		
		//空心金字塔
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*i-1; j++) {
				if(j == 1 || j == 2*i - 1 || i == 6) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
}
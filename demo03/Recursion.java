package demo03;

// 递归
public class Recursion {
	public static void main(String[] args) {

		T t = new T();
//		t.test(4);
//		System.out.println(t.factorial(4));
//		System.out.println(t.fibonacci(7));
		System.out.println(t.peachNum(1));

	

	}
}

class T {

	public void test(int n) {
		if (n > 2) {
			test(n - 1);
		}
		System.out.println("n = " + n);
	}

	// 阶乘
	public int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return factorial(n - 1) * n;
	}

	// 斐波那契数列
	public int fibonacci(int n) {
		if (n < 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// 猴子吃桃问题
	public int peachNum(int day) {
		if (day == 10) {
			return 1;
		} else if (day >= 1 && day <= 9) {
			return 2 * (peachNum(day + 1) + 1);
		} else {
			System.out.println("请输入1-10");
			return -1;
		}
	}


}
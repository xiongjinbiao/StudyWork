package demo03;

// 可变参数
public class VarParameter {
	public static void main(String[] args) {

		GetT t = new GetT();
		System.out.println(t.sum(1, 2, 4));

	}
}

class GetT {

//	public int sum(int n) {
//		return n * n;
//	}
//
//	public int sum(int n, int m) {
//		return m * n;
//	}
//
//	public int sum(int n, int m, int j) {
//		return m * n * j;
//	}

	// 传参num可以看做为一个数组，只能出现一个可变参数,当既有可变参数，又有固定参数时候，可变参数一定要放到最前面
	public int sum(int... num) {
		int ji = 1;
		for (int i = 0; i < num.length; i++) {
			ji *= num[i];
		}
		return ji;
	}

}
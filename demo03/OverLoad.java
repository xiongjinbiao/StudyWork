package demo03;

public class OverLoad {
	public static void main(String[] args) {

		Methods m = new Methods();
		m.method(1);
		m.method(1,2);
		m.method(1,2,3);

	}
}

class Methods {

	public int method(int n) {
		return n * n;
	}

	public int method(int n, int m) {
		return m * n;
	}

	public void method(int n, int m, int j) {
		System.out.println(m * n * j);
	}

}
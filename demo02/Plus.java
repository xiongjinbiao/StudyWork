package demo02;
public class Plus {
	public static void main(String[] args) {
		
		// + 使用原则：从左往右依次计算
		System.out.println("hello" + 100 + 3); // hello1003
		System.out.println(100 + 3); //103
		System.out.println("100" + 3); //1003
		System.out.println(100 + 3 + "hello"); //103hello

	}
}
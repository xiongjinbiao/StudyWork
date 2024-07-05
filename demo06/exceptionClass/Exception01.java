package demo06.exceptionClass;

public class Exception01 {
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 0;
		
//		int res = num1 / num2;
		int res = 0;
		try {
			res = num1 /num2;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception reason : "+e.getMessage());
		}
		
		System.out.println(res);
		System.out.println("程序继续执行...");

	}
}

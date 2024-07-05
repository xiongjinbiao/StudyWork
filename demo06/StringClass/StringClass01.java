package demo06.StringClass;

public class StringClass01 {

	public static void main(String[] args) {
		
		/**
		 *   %s      字符串  
		 *   %d      整数 
		 *   %.03f 小数(保留三位有效数字，四舍五入，位数不足用0补) 
		 *   %c      char字符
		 */
		Float a = 2.1f;
		System.out.println(String.format("%.03f", a));

		String str = "xiongjinbiao";

		char[] c = str.toCharArray();

		for (char d : c) {
			System.out.print(d + "  ");
		}	
		
		
	}
}

package demo02;
public class StringToOther {
	public static void main(String[] args) {
		
		// 该字符串格式必须为数据格式
		String s = "12";                                           
		int num1 = Integer.parseInt(s);
		double num2 = Double.parseDouble(s);
		float num3 = Float.parseFloat(s);
		short num4 = Short.parseShort(s);
		byte num5 = Byte.parseByte(s);
		long num6 = Long.parseLong(s);
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		System.out.println(num6);
		
	}
}
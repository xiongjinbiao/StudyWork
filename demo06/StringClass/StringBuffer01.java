package demo06.StringClass;

// StringBuffer StringBuilder 方法都是一致的，只是StringBuffer的方法多个synchronized，适用于多线程
// 字符串修改速度顺序 StringBuilder  StringBuffer   String
// 只涉及修改，多线程使用StringBuffer，单线程StringBuilder
// 字符串涉及频繁复用，使用String
public class StringBuffer01 {
	@SuppressWarnings("all")
	public static void main(String[] args) {

		// create by length
		StringBuffer sbByLength = new StringBuffer(199);

		// String -> StringBuffer
		StringBuffer sb = new StringBuffer("姓名 : ");

		sb.append("xiong ");
		sb.append("jin ");
		sb.append("biao");

		System.out.println(sb);

		// StringBuffer -> String
		String sb1 = sb.toString();
		String sb2 = new String(sb);

		System.out.println(sb1);
		System.out.println(sb2);

	}
}

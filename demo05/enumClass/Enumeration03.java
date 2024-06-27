package demo05.enumClass;

public class Enumeration03 {
	public static void main(String[] args) {

		Season1 atumn = Season1.ATUMN;

		System.out.println(atumn.name());
		// 返回创建枚举对象的顺位，从0开始
		System.out.println(atumn.ordinal());
		// 返回所有枚举对象
		Season1[] values = Season1.values();
		for (Season1 season1 : values) {
			System.out.println(season1);
		}
		// 查找枚举对象
		Season1 spring = Season1.valueOf("SPRING");
		System.out.println(spring);
		// 比较两个枚举对象的顺位差
		System.out.println(atumn.compareTo(spring));
		
	}
}

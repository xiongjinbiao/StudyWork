package demo05.enumClass;

public class Enumeration02 {
	public static void main(String[] args) {

		System.out.println(Season1.SPRING);
		System.out.println(Season1.SUMMER);
		System.out.println(Season1.ATUMN);
		System.out.println(Season1.WINTER);

	}
}

// 使用枚举关键字
enum Season1 {

	SPRING("spring", "温暖"), SUMMER("summer", "炎热"), ATUMN("atumn", "凉爽"), WINTER("winter", "寒冷");

	private String name;
	private String desc;

	private Season1(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return "Serson1 [name=" + name + ", desc=" + desc + "]";
	}

}
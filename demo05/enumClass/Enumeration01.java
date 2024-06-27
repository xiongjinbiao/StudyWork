package demo05.enumClass;

public class Enumeration01{
	public static void main(String[] args) {
		
		System.out.println(Season.SPRING);
		System.out.println(Season.SUMMER);
		System.out.println(Season.ATUMN);
		System.out.println(Season.WINTER);

		
	}
}

// 自定义枚举
class Season{
	
	@SuppressWarnings("unused")
	private int i = 1;
	
	private String name;
	private String desc;
	
	public final static Season SPRING = new Season("spring","温暖");
	public final static Season SUMMER = new Season("summer","炎热");
	public final static Season ATUMN = new Season("atumn","凉爽");
	public final static Season WINTER = new Season("winter","寒冷");

	
	public Season(String name, String desc) {
		super();
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
		return "Serson [name=" + name + ", desc=" + desc + "]";
	}

	
	
	
}
package demo03.poly;

public class Master {

	private String name;

//	public Master() {
//		super();
//	}

	public Master(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 多态的使用
	public void feed(Animal animal, Food food) {
		System.out.println(name + "给" + animal.getName() + "喂" + food.getName());
	}

}
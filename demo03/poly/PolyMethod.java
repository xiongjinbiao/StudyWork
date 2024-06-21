package demo03.poly;

// 调用方法看的是运行类型，调用属性是哪里有声明哪里使用
public class PolyMethod {
	public static void main(String[] args) {
		
		Master master = new Master("master");
		
		// 多态的向上转型，即父类的引用指向的子类的对象（编译的是Animal，运行的是Dog）
		Animal animal = new Dog("史莱姆");
		Food food = new Bone("大棒骨");
		
		master.feed(animal, food);
		
		Dog dog = (Dog) animal; // 这里的animal本质上是dog
//		Cat cat = (Cat) animal; //这样写会报错，因为猫和狗之间不存在继承关系
		dog.stayHome();
		
	
		Animal animal1 = new Cat("小三花"); // 这里的animal可以理解为披着animal的cat，本质还是cat
		Food food1 = new Fish("黄花鱼");
		
		master.feed(animal1, food1);
		
		// 多态的向下转型（前提是这个animal1的本质是cat，不可以是披着其他子类的animal1）
		// 向下转型以后，可以使用子类（cat）的所有成员（方法，属性，构造器。。。）
		Cat cat = (Cat) animal1; //可以理解为把外层的animal丢掉，强转为cat
		cat.catchMouse();
		
	}
}
package demo05.abstractClass;

public abstract class Animal {
	// 抽象方法：没有方法体，必须由子类实现
	public abstract void makeSound();

	// 具体方法：有方法体，非必须实现
	public void sleep() {
		System.out.println("Sleeping...");
	}
}

class Dog extends Animal {
	// 实现抽象方法
	@Override
	public void makeSound() {
		System.out.println("Bark");
	}
}

class Cat extends Animal {
	// 实现抽象方法
	@Override
	public void makeSound() {
		System.out.println("Meow");
	}
}

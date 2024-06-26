package demo05.interfaceClass;

public class Interface01{
	public static void main(String[] args) {
		
		Baby baby = new Baby();
		baby.cry();
		baby.say();
		// 推荐使用这种调用，更符合静态static关键字用法
		System.out.println(AA.age);
		System.out.println(BB.weight);
//		System.out.println(Baby.age);
//		System.out.println(baby.weight);
		
//		AA.age = 10; 错误的使用方法，因为final定义的变量是不可以被修改的
		
		/** final细节
		 * final 类：不能被继承，用于防止子类修改类的行为。
         * final 方法：不能被子类重写，用于确保方法行为不被改变。
         * final 变量：在初始化之后不能被修改，用于定义常量或保证变量的不可变性
		 */

	}
}


class Baby implements BB,AA{

	public void cry() {
		System.out.println("baby is crying");
	}

	public void say() {
		System.out.println("baby is saying");
	}
	
}
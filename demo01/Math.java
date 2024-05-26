package demo01;
// b=++a 和 b=a++ 的区别：前者是先运算再取值，后者为先取值再计算(这里说的都是相对于b的值而言，a两者是一样的) --同理
public class Math {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		int c = 4;
		
		System.out.println("a+b的值 " + a+b);
		System.out.println("a-b的值 " + (a-b));
		System.out.println("a*b的值 " + a*b);
		System.out.println("a/b的值 " + a/b);
		System.out.println("a%b的值 " + a%b);
		System.out.println("c++的值 " + c++);
		System.out.println("c--的值 " + c--);
		System.out.println("--c的值 " + --c);
		System.out.println("++c的值 " + ++c);
		
	}
	
}
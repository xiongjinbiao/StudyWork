package demo05.abstractClass;

public class Abstract01{
	public static void main(String[] args) {
		
//		Animal animal = new Animal(); // 编译错误
		
		Circle circle = new Circle("blue",3);
		System.out.println("直径为"+circle.getRadius()+"的圆面积是 " +circle.area());
	}
}
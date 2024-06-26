package demo05.innerClass;

public class InnerClassExercise01 {
	public static void main(String[] args) {

		CellPhone cellPhone = new CellPhone();
		cellPhone.alarm(new Bell() { // 接口的内部类的实例化的参数

			public void ring() {
				System.out.println("pig hurry up");
			}

		});

	}
}

interface Bell {
	void ring();
}

class CellPhone {
	public void alarm(Bell bell) {
		bell.ring();
	}

}
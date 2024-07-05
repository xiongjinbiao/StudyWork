package demo06.exceptionClass;


public class CustomException {
	public static void main(String[] args) {

		int age = 30;

		if (!(age >= 18 && age <= 20)) {
			throw new AgeException("年龄需要在 18～20");
		}
		

	}
}

@SuppressWarnings("serial")
class AgeException extends RuntimeException{

	public AgeException(String message) {
		super(message);
	}

}
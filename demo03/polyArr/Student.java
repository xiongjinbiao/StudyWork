package demo03.polyArr;

public class Student extends Person {

	private int score;

	public Student() {
		super();
	}

	public Student(String name, int age, int score) {
		super(name, age);
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String showInfo() {
		return "student " + super.showInfo() + ", score=" + score;
	}

	public String study() {
		return super.getName() + "正在学习java 。。。";
	}

}
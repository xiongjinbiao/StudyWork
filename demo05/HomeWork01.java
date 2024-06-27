package demo05;

public class HomeWork01 {
	public static void main(String[] args) {

		Color red = Color.RED;
		red.showColor();

		switch (red) {
		case RED:
			System.out.println("this is red");
			break;
		case BLUE:
			System.out.println("this is blue");
			break;
		default:
			System.out.println("miss color");
		}

	}
}

interface ColorInterface {
	void showColor();
}

enum Color implements ColorInterface {

	RED(1, 2, 3), GREEN(4, 5, 6), BLUE(7, 8, 9);

	private int red;
	private int green;
	private int blue;

	private Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	@Override
	public void showColor() {
		System.out.println("red " + red + ",green " + green + ",blue " + blue);
	}

}
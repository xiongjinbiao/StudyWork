package demo03;

/*
 * 汉诺塔
 */

public class RecursionExercise02 {
	public static void main(String[] args) {
		Tower tower = new Tower();
		tower.move(3, 'a', 'b', 'c');
	}
}

class Tower {

	public void move(int num, char a, char b, char c) {
		// 只有一个盘子
		if (num == 1) {
			System.out.println(a + " -> " + c);
		} else {
			// 如果有多个盘子，可以分成了两部分看，一部分为最底下一个，另一部分为num-1
			// 先把a上面num-1个盘子借助c放到b
			move(num - 1, a, c, b);
			// 再把a下面一个盘子放到c
			System.out.println(a + " -> " + c);
			// 再把b上num-1个盘子借助a放到c
			move(num - 1, b, a, c);
		}
	}

}
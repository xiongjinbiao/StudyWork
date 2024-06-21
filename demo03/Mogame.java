package demo03;

import java.util.Random;
import java.util.Scanner;

public class Mogame {
	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);
		Tom t = new Tom();
		int times = t.count;

		int[][] arr = new int[times][3];
		String[] res = new String[times];
		int winCount = t.winCountNum;

		for (int i = 0; i < times; i++) {

			System.out.println("请输入猜拳，0-石头，1-剪刀，2-布");
			int tomGuessNum = sca.nextInt();
			int comGuessNum = t.computerNum();

			t.tomGuessNum = tomGuessNum;
			t.comGuessNum = comGuessNum;
			arr[i][0] = tomGuessNum;
			arr[i][1] = comGuessNum;
			arr[i][2] = i + 1;
			String resStr = t.guessRes();
			res[i] = resStr;
			if (resStr.equals("你赢了")) {
				winCount++;
			}

			System.out.println("局数\ttom\tcomputer\t胜负关系");
			System.out.println((i + 1) + "\t" + tomGuessNum + "\t" + comGuessNum + "\t" + resStr);
		}
		System.out.println("一起玩了" + times + "局，赢了" + winCount + "局");
	}
}

class Tom {

	int tomGuessNum;
	int comGuessNum;
	int winCountNum;
	int count = 3;

	// 电脑随机生成0，1，2
	public int computerNum() {
		return new Random().nextInt(3);
	}

	// 判断玩家输入的数字是否有效

	// 比较猜拳的结果
	public String guessRes() {
		if (this.tomGuessNum == 0 && this.comGuessNum == 1) {
			return "你赢了";
		} else if (this.tomGuessNum == 1 && this.comGuessNum == 2) {
			return "你赢了";
		} else if (this.tomGuessNum == 2 && this.comGuessNum == 0) {
			return "你赢了";
		} else if (this.tomGuessNum == this.comGuessNum) {
			return "平手";
		} else {
			return "你输了";
		}
	}

}
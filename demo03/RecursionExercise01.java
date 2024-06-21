package demo03;

/*
 * 迷宫问题找路问题 
 * 初始位置[1][1]  
 * 0可以走的路 1障碍物 2可以走（四个方向有一个方向可以走即可） 3走过但是是死路
 */

public class RecursionExercise01 {
	public static void main(String[] args) {

		// 设置迷宫的形状
		int[][] map = new int[8][7];
		for (int i = 0; i <= 6; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int i = 0; i <= 7; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;

		System.out.println("迷宫形状");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}

		MiGong mg = new MiGong();
		mg.findWay(map, 1, 1);

		System.out.println("出迷宫路线图");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}

	}
}

class MiGong {

	public boolean findWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			return true;
		} else {
			if (map[i][j] == 0) {
				map[i][j] = 2; // 假设这个点可以走通，使用findWay来验证是否真的可以走通
				// 下 右 上 左 （策略先后顺序可以改变，优先级不同，最后结果路线也会有所不同）
				if (findWay(map, i + 1, j)) {
					return true;
				} else if (findWay(map, i, j + 1)) {
					return true;
				} else if (findWay(map, i - 1, j)) {
					return true;
				} else if (findWay(map, i, j - 1)) {
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else {
				return false;
			}
		}
	}

}
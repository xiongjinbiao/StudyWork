package demo03;

/*
board数组：用来记录每行皇后放置的位置，board[row] = col表示第row行的皇后放置在第col列。
isSafe方法：检查在给定位置放置皇后是否安全，通过检查是否在同一列或对角线上。
solve方法：递归地尝试在每一行放置皇后，若成功则继续下一行，若失败则回溯。
printBoard方法：打印当前棋盘布局，Q表示皇后，.表示空位。
*/

public class EightQueens {
	private static final int N = 8;
	private int[] board = new int[N];

	public static void main(String[] args) {
		EightQueens queens = new EightQueens();
		queens.solve(0);
	}

	private void solve(int row) {
		if (row == N) {
			printBoard();
			return;
		}
		for (int col = 0; col < N; col++) {
			if (isSafe(row, col)) {
				board[row] = col;
				solve(row + 1);
				board[row] = -1; // 回溯
			}
		}
	}

	private boolean isSafe(int row, int col) {
		for (int i = 0; i < row; i++) {
			int placedCol = board[i];
			if (placedCol == col || Math.abs(placedCol - col) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}

	private void printBoard() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (board[row] == col) {
					System.out.print("Q ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}

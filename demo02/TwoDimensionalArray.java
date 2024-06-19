package demo02;

public class TwoDimensionalArray {
	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		int[][] arr1 = new int[4][4];
		arr1[1][2] = 2;
		arr1[2][1] = 1;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}

		// 二维数组存在列数不唯一的情况（每个维度的数组元素个数不一定要保持一致）
		int[][] arr3 = new int[3][];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = new int[i + 1];
			for (int j = 0; j < arr3[i].length; j++) {
				arr3[i][j] = i + 1;
			}
		}
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.print(arr3[i][j] + " ");
			}
			System.out.println();
		}

		int[][] yanghui = new int[10][];
		for (int i = 0; i < yanghui.length; i++) {
			yanghui[i] = new int[i + 1];
			for (int j = 0; j < yanghui[i].length; j++) {
				if (j == 0 || j == yanghui[i].length - 1) {
					yanghui[i][j] = 1;
				} else {
					yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
				}
			}
		}
		
		for (int i = 0; i < yanghui.length; i++) {
			for (int j = 0; j < yanghui[i].length; j++) {
				System.out.print(yanghui[i][j] + " ");
			}
			System.out.println();
		}

	}
}
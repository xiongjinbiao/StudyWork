package demo02;

/*
 * 冒泡排序
 * 1，第一轮把最大数放到最后
 * 2，第二轮把第二大数放到倒数第二位置
 * 3，第三轮把第三大数放到倒数第三位置
 * 4，后续以此类推。。。 
 */

public class BubbleSort {
	public static void main(String[] args) {

		int[] arr = { 12, 43, 165, 6, 65 };
		int temp = 0;
		double startTime = System.currentTimeMillis();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println("\n" + "第" + (i + 1) + "轮排序的结果");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
		}
		double endTime = System.currentTimeMillis();
		System.out.println("\n" + "排序耗时为 " + (endTime - startTime) + "ms");

	}
}
package demo02;

import java.util.Scanner;

public class Array {
	public static void main(String[] args) {

		// 定义数组
		double[] hens = { 3, 5, 1, 3.4, 2, 50 };
//		double hens[] = { 3, 5, 1, 3.4, 2, 50 }; 与上方一致
		double totalWeight = 0d;
		// 遍历数组
		for (int i = 0; i < hens.length; i++) {
//			System.out.println("第" + (i + 1) + "个元素的值为 " + hens[i]);
			totalWeight += hens[i];
		}
//		System.out.println("总体重= " + totalWeight + "\n" + "平均体重 = " + (totalWeight / hens.length));

		// 循环输入
//		Scanner myScanner = new Scanner(System.in);
//		double[] scores = new double[5];
//		for (int i = 0; i < scores.length; i++) {
//			System.out.println("请输入第" + (i + 1) + "个值");
//			scores[i] = myScanner.nextDouble();
//		}

//		char[] chars = new char[26];
//		for (int i = 0; i < chars.length; i++) {
//			chars[i] = (char) ('A' + i);
//		}

		// 求数组最大值
		int[] arr = { 11, 32, -1, 314, 54 };
		int max = arr[0];
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
		}
		System.out.println("max = " + max + " maxIndex =  " + maxIndex);

	}
}
package demo02;

public class ArrayExercise {
	public static void main(String[] args) {

		// 在一个升序数组中随机添加一个元素，使新数组仍是一个升序数组
		int[] arr = { 12, 14, 15, 45 };
		int insertNum = 23;
		int insertIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (insertNum <= arr[i]) {
				insertIndex = i;
				break;
			}
		}
		if (insertIndex == -1) {
			insertIndex = arr.length;
		}
		// 扩容
		int[] arrNew = new int[arr.length + 1];
		// j用来控制旧数组的index，i用来控制新数组的index
		for (int i = 0, j = 0; i < arrNew.length; i++) {
			if (i != insertIndex) {
				arrNew[i] = arr[j];
				j++;
			} else {
				arrNew[i] = insertNum;
			}
		}

		//逆序
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println("\n" + "---arr1---");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		for (int i = arr1.length - 1, j = 0; i >= 0; i--, j++) {
			arr2[j] = arr1[i];
		}
		System.out.println("\n" + "---arr2---");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		
		//求最大值以及对应下标，平均值
		int max =arr1[0];
		double avg =0f;
		double sum = 0;
		int maxIndex =0;
		for (int i = 1; i < arr1.length; i++) {
			sum += arr1[i];
			if (max < arr1[i]) {
				max = arr1[i];
				maxIndex = i;
			}
		}
		System.out.println("\n" + "最大值为 "+max+"，下标为 " + maxIndex+"，平均值为 "+(sum/arr1.length));
		//查找数是否存在以及若存在打印下标
		int findNum = 25;
		int findNumIndex = -1;
		for (int i = 0; i < arr1.length; i++) {
			if (findNum == arr1[i]) {
				findNumIndex = i;
				System.out.println("\n" + findNum + "找到了，下标为" + findNumIndex);
				break;
			}
		}
		if (findNumIndex == -1) {
			System.out.println("\n" + findNum + "没有找到");
		}
		
		//冒泡排序
		int temp = 0;
		for (int i = 0; i < arr2.length-1; i++) {
			for (int j=0;j<arr2.length-1-i;j++) {
				if(arr2[j] > arr2[j+1]) {
					temp = arr2[j];
					arr2[j]=arr2[j+1];
					arr2[j+1]=temp;
				}
			}
		}
		System.out.println("\n" + "---排序后的arr2---");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}

	}
}
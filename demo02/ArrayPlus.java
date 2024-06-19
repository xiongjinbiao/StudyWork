package demo02;

public class ArrayPlus {
	public static void main(String[] args) {

		// array赋值
		int[] arr1 = { 1, 2, 3 };
		// 其实是将arr1的地址copy一份给arr2（数组存储方式为一个二进制的地址）,此时arr1和arr2共享一个存储地址，arr1和arr2永远保持相同，因为共享一个地址
		int[] arr2 = arr1;
		arr2[0] = 10;// 通过索引赋值
		System.out.println("---arr1---");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println("\n" + "---arr2---");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}

		int[] arr3 = new int[arr1.length];// 此时arr3在内存中新创建了一个存储地址，因为赋值对arr1不会有任何影响
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = arr1[i];
		}
		arr3[0] = 100;
		System.out.println("\n" + "---arr3---");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}

		// 将arr3翻转为arr4
		int[] arr4 = new int[arr3.length];

//		1，逆序遍历赋值
//		for (int i = 0; i < arr3.length; i++) {
//			arr4[i] = arr3[arr3.length - 1 - i];
//		}

//		for (int i = arr3.length-1; i >=0; i--) {
//			arr4[i] = arr3[arr3.length - 1 - i];
//		}

		// 2，使用双指针
		for (int i = arr3.length - 1, j = 0; i >= 0; i--, j++) {
			arr4[j] = arr3[i];
		}

//		for (int i = 0, j = arr3.length - 1; i < arr3.length; i++, j--) {
//			arr4[i] = arr3[j];
//		}

		System.out.println("\n" + "---arr4---");
		for (int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i] + " ");
		}

	}
}
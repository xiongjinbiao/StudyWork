package demo02;

import java.util.Scanner;

public class VarDetail {
	public static void main(String[] args) {
		/*
		 * 数据类型可以从小精度往大精度自动从转换，但是char与byte，short之间无法自动转换 数据计算最后的结果取自计算数值的最大精度（char short
		 * byte 三者计算结果自动转换为 int） char -> int -> long -> float -> double byte -> short ->
		 * int -> long -> float -> double
		 */
		int a = 10;
		long b = 11L;
		float c = 1.1f;
		float c_x = .1f;
		double d = 1.1;
		double e = 1.1f; // double的精度高于float

		// char 本质是一个整数,其存储编码格式为Unicode
		char f = 'a';
		char h = 97;
		System.out.println((int)f); // 输出时候需要转换为int
		System.out.println(h);

		// char short byte 三者计算结果自动转换为 int
		byte b1 = 1;
		short s1 = 2;
		char c1 = 3;
		int r = b1 + s1;
//		byte r1 = b1 + b1; 会报错

		// boolean 默认为true
		boolean pass = true;
		if (pass) {
			System.out.println("考试合格");
		} else {
			System.out.println("考试不合格");
		}

		// 三元表达式
		String s = pass == true ? "考试合格" : "考试不合格";

		// 接受用户输入，一个简单的文本扫描器
		Scanner myScanner = new Scanner(System.in);
		System.out.println("input your name");
		String name = myScanner.next();
		System.out.println("input your age");
		int age = myScanner.nextInt();

	}
}
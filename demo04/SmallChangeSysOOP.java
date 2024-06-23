package demo04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class SmallChangeSysOOP {

	private double money;
	private double balance;
	private Date date;
	private String note;

	public SmallChangeSysOOP() {
		super();
	}

	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	boolean flag = true;

	// 显示零钱通菜单功能
	public void mainMenu() {

		System.out.println("====零钱通菜单====");
		System.out.println("\t1.账单明细\n" + "\t2.入账\n" + "\t3.消费\n" + "\t4.退出\n");

		do {
			System.out.println("请输入你要选择的功能");
			int key = sc.nextInt();

			switch (key) {
			case 1:
				this.showDetails();
				break;
			case 2:
				this.getIncome();
				break;
			case 3:
				this.pay();
				break;
			case 4:
				this.exit();
				break;
			default:
				System.out.println("输入有误");
			}

		} while (flag);

	}

	// 记录账单明细
	ArrayList<String> details = new ArrayList<String>();

	// 显示零钱通明细
	public void showDetails() {
		System.out.println("====账单明细====");
		// 遍历arraylist方法
		// 1，for循环
		if (details.isEmpty()) {
			System.out.println("目前无任何账单");
		} else {
			for (int i = 0; i < details.size(); i++) {
				System.out.println(details.get(i) + "\t");
			}
		}

		// 2，lambda表达式
//		details.forEach(detail -> System.out.println(detail));

		// 3，增强for循环
//		for (String str : details) {
//			System.out.println(str);
//		}

		// 4，迭代器
//        Iterator<String> iterator = details.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

	}

	// 显示收入
	public void getIncome() {

		System.out.println("收益金额：");
		money = sc.nextDouble();
		if (money <= 0) {
			System.out.println("收入金额数字应大于0");
		} else {
			System.out.println("收益来源：");
			note = sc.next();
			balance += money;
			date = new Date();
			details.add(note + "\t" + money + "\t" + sdf.format(date) + "\t" + balance);
		}

	}

	// 显示消费
	public void pay() {

		System.out.println("消费金额：");
		money = sc.nextDouble();
		if (money <= 0) {
			System.out.println("消费金额数字应大于0");
		} else {
			System.out.println("消费用途：");
			note = sc.next();
			balance -= money;
			date = new Date();
			details.add(note + "\t" + -money + "\t" + sdf.format(date) + "\t" + balance);
		}

	}

	// 退出
	public void exit() {

		System.out.println("是否退出");
		String choose = "";
		// 先判断用户输入是否有误，若无误在判断是否退出程序
		while (true) {
			choose = sc.next();
			if (!("n".equals(choose.toLowerCase()) || "y".equals(choose.toLowerCase()))) {
				System.out.println("只能输入 y/n 或 Y/N");
			} else {
				break;
			}
		}

		if ("y".equals(choose.toLowerCase())) {
			System.out.println("已退出");
			flag = false;
		}

	}

}
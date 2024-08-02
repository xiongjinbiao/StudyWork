package mhl.view;

import java.util.List;

import mhl.domain.Bill;
import mhl.domain.DiningTable;
import mhl.domain.Employee;
import mhl.domain.Menu;
import mhl.service.BillService;
import mhl.service.DiningTableService;
import mhl.service.EmployeeService;
import mhl.service.MenuService;
import mhl.utils.Utility;

public class MHLView {

	// 控制是否退出菜单
	private boolean loop = true;
	// 接受用户的选择
	private String key = "";
	// service类
	private EmployeeService employeeService = new EmployeeService();
	private DiningTableService diningTableService = new DiningTableService();
	private MenuService menuService = new MenuService();
	private BillService billService = new BillService();

	/**
	 * 显示所有餐桌状态
	 */
	public void listDiningTable() {

		System.out.println("\n餐桌编号\t\t餐桌状态");
		List<DiningTable> list = diningTableService.list();
		for (DiningTable diningTable : list) {
			System.out.println(diningTable);
		}
		System.out.println("======显示完毕======\n");

	}

	/**
	 * 预定餐桌
	 */
	public void orderDiningTable() {

		System.out.println("======预定餐桌======");
		System.out.println("请选择要预定的餐桌编号(-1退出)：");
		int orderId = Utility.readInt();

		if (orderId == -1) {
			return;
		}

		// 是否预定
		char key = Utility.readConfirmSelection();
		// 预定
		if (key == 'Y') {
			DiningTable diningTable = diningTableService.getDiningTableById(orderId);

			if (diningTable == null) {
				System.out.println("======预定餐桌不存在======");
				return;
			}
			if (!("空".equals(diningTable.getState()))) {
				System.out.println("该餐桌就餐中");
				return;
			}

			// 接受预订信息
			System.out.println("请输入姓    名：");
			String name = Utility.readString(50);
			System.out.println("请输入手机号：");
			String tel = Utility.readString(50);

			// 更新餐桌状态
			if (diningTableService.orderDiningTable(orderId, name, tel)) {
				System.out.println("======预定成功======");
			} else {
				System.out.println("======预定失败======");
			}

		} else {
			System.out.println("======取消预定======");
		}

	}

	/**
	 * 显示所有菜品
	 */
	public void listMenu() {

		System.out.println("\n编号\t\t\t名称\t\t\t类型\t\t\t价格");
		List<Menu> list = menuService.list();
		for (Menu menu : list) {
			System.out.println(menu);
		}
		System.out.println("======显示完毕======\n");

	}

	/**
	 * 点餐服务
	 */
	public void orderMenu() {
		System.out.println("======点餐服务======");
		System.out.println("请选择餐桌编号(-1退出)：");
		int diningTableId = Utility.readInt();
		if (diningTableId == -1) {
			System.out.println("======取消点餐======");
			return;
		}
		System.out.println("请选择菜品编号(-1退出)：");
		int menuId = Utility.readInt();
		if (menuId == -1) {
			System.out.println("======取消点餐======");
			return;
		}
		System.out.println("请选择数量(-1退出)：");
		int nums = Utility.readInt();
		if (nums == -1) {
			System.out.println("======取消点餐======");
			return;
		}

		// 验证餐桌是否存在
		DiningTable diningTable = diningTableService.getDiningTableById(diningTableId);
		if (diningTable == null) {
			System.out.println("======餐桌号不存在======");
			return;
		}

		// 验证菜品号是否存在
		Menu menu = menuService.getMenuById(menuId);
		if (menu == null) {
			System.out.println("======菜品号不存在======");
			return;
		}

		// 点餐
		if (billService.orderMenu(menuId, nums, diningTableId)) {
			System.out.println("======点餐成功======");
		} else {
			System.out.println("======点餐失败======");
		}

	}

	/**
	 * 查看订单
	 */
	public void listBill() {

		System.out.println("\n编号\t\t菜品号\t\t数量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t状态");
		List<Bill> list = billService.list();
		for (Bill bill : list) {
			System.out.println(bill);
		}
		System.out.println("======显示完毕======\n");

	}

	/**
	 * 结账
	 */
	public void payBill() {

		System.out.println("请选择要结账的餐桌编号(-1退出)：");
		int diningTableId = Utility.readInt();
		if (diningTableId == -1) {
			System.out.println("======取消结账======");
			return;
		}

		// 验证餐桌是否存在
		DiningTable diningTable = diningTableService.getDiningTableById(diningTableId);
		if (diningTable == null) {
			return;
		} else {
			System.out.println("======餐桌编号不存在======");
		}

		// 验证餐桌是否有未结账的菜单
		if (!billService.hasPayBillByDiningTableId(diningTableId)) {
			return;
		} else {
			System.out.println("======该餐桌不存在未结账的账单======");
		}

		System.out.println("结账方式(现金/支付宝/微信)回车表示退出");
		String payMode = Utility.readString(20, "");
		if ("".equals(payMode)) {
			return;
		}

		char key = Utility.readConfirmSelection();
		if (key == 'Y') {
			if (billService.payBill(diningTableId, payMode)) {
				System.out.println("======结账成功======");
			} else {
				System.out.println("======结账失败======");
			}
		} else {
			System.out.println("======取消结账======");
		}

	}

	/**
	 * 显示主菜单
	 */
	public void mainMenu() {

		while (loop) {

			System.out.println("======满汉楼======");
			System.out.println("\t\t 1 登录满汉楼");
			System.out.println("\t\t 2 退出满汉楼");
			System.out.println("请输入你的选择：");
			key = Utility.readString(1);
			switch (key) {
			case "1":
				System.out.println("输入员工号：");
				String id = Utility.readString(50);
				System.out.println("输入密    码：");
				String pwd = Utility.readString(50);
				Employee employee = employeeService.getEmployeeByIdAndPwd(id, pwd);
				if (employee != null) {
					System.out.println("======欢迎登录 [" + employee.getName() + " " + employee.getJob() + "] ======");
					while (loop) {
						System.out.println("======满汉楼(二级菜单)======");
						System.out.println("\t\t 1 显示餐桌状态");
						System.out.println("\t\t 2 预定餐桌");
						System.out.println("\t\t 3 显示所有菜品");
						System.out.println("\t\t 4 点餐服务");
						System.out.println("\t\t 5 查看订单");
						System.out.println("\t\t 6 结账");
						System.out.println("\t\t 9 退出满汉楼");
						key = Utility.readString(1);
						switch (key) {
						case "1":
							listDiningTable();
							break;
						case "2":
							orderDiningTable();
							break;
						case "3":
							listMenu();
							break;
						case "4":
							orderMenu();
							break;
						case "5":
							listBill();
							break;
						case "6":
							payBill();
							break;
						case "9":
							loop = false;
							System.out.println("\t\t 9 退出满汉楼");
							break;
						default:
							System.out.println("输入有误");
						}
					}
				}
				break;
			case "2":
				loop = false;
				System.out.println("退出满汉楼");
				break;
			default:
				System.out.println("输入有误");
			}

		}

	}

}

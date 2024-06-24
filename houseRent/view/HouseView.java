package demo04.houseRent.view;

import demo04.houseRent.domain.House;
import demo04.houseRent.service.HouseService;
import demo04.houseRent.utils.Utility;

public class HouseView {

	private boolean loop = true;
	private char key = ' ';

	private HouseService houseService = new HouseService(10);

	public void listHouses() {

		System.out.println("====房屋信息列表====");
		System.out.println("编号" + "\t房主" + "\t电话" + "\t地址" + "\t月租" + "\t状态");
		House[] houses = houseService.list();
		for (int i = 0; i < houses.length; i++) {
			if (houses[i] == null) {
				break;
			}
			System.out.println(houses[i]);
		}
		System.out.println("====房屋列表显示完毕====\n");

	}

	public void addHouse() {
		System.out.println("====添加房屋信息====");
		System.out.print("姓名");
		String name = Utility.readString(8);
		System.out.print("电话");
		String phone = Utility.readString(12);
		System.out.print("地址");
		String address = Utility.readString(8);
		System.out.print("月租");
		int rent = Utility.readInt();
		System.out.print("状态");
		String state = Utility.readString(8);
		House house = new House(0, name, phone, address, rent, state);
		if (houseService.add(house)) {
			System.out.println("房屋编号" + house.getId() + "添加成功");
		} else {
			System.out.println("添加失败");
		}
	}

	public void delHouse() {
		System.out.println("====删除房屋信息====");
		System.out.println("请输入要删除的房屋编号（-1退出）");
		int delId = Utility.readInt();
		if (delId == -1) {
			System.out.println("放弃删除房屋信息");
			return;
		}
		// 再次确认是否删除
		char choice = Utility.readConfirmSelection();
		if (choice == 'Y') {
			if (houseService.del(delId)) {
				System.out.println("房屋编号" + delId + "删除成功");
			} else {
				System.out.println("房屋编号" + delId + "不存在，删除失败");
			}
		} else {
			System.out.println("放弃删除");
		}
	}

	public void exit() {
		char c = Utility.readConfirmSelection();
		if (c == 'Y') {
			loop = false;
		}
	}

	public void findHouse() {
		System.out.println("====查找房屋信息====");
		System.out.println("请输入要查找的房屋编号");
		int findId = Utility.readInt();
		House house = houseService.findById(findId);
		if (house != null) {
			System.out.println("编号" + "\t房主" + "\t电话" + "\t地址" + "\t月租" + "\t状态");
			System.out.println(house + "\n");
		} else {
			System.out.println("房屋编号" + findId + "信息未找到");
		}
	}

	public void updateHouse() {
		System.out.println("====修改房屋信息====");
		System.out.println("请输入要修改的房屋编号（-1退出）");
		int updateId = Utility.readInt();
		if (updateId == -1) {
			System.out.println("放弃修改房屋信息");
			return;
		}
		House house = houseService.findById(updateId);
		if (house == null) {
			System.out.println("房屋编号" + updateId + "信息未找到");
			return;
		}
		System.out.println("当前房主 " + house.getName());
		String name = Utility.readString(8, " ");
		if (!" ".equals(name)) {
			house.setName(name);
		}
		System.out.println("当前电话 " + house.getPhone());
		String phone = Utility.readString(12, " ");
		if (!" ".equals(phone)) {
			house.setPhone(phone);
		}
		System.out.println("当前地址 " + house.getAddress());
		String address = Utility.readString(12, " ");
		if (!" ".equals(address)) {
			house.setAddress(address);
		}
		System.out.println("当前月租 " + house.getRent());
		int rent = Utility.readInt();
		if (rent > 0) {
			house.setRent(rent);
		}
		System.out.println("当前状态 " + house.getState());
		String status = Utility.readString(12, " ");
		if (!" ".equals(status)) {
			house.setState(status);
		}
	}

	public void mainMenu() {

		do {

			System.out.println("====房屋出租系统菜单====");
			System.out.println("\t1.新增房源\n" + "\t2.查找房源\n" + "\t3.删除房屋信息\n" + "\t4.修改房租信息\n" + "\t5.房屋列表\n" + "\t6.退出");
			System.out.println("输入你的选择 1-6");
			key = Utility.readChar();
			switch (key) {
			case '1':
				this.addHouse();
				break;
			case '2':
				this.findHouse();
				break;
			case '3':
				this.delHouse();
				break;
			case '4':
				this.updateHouse();
				break;
			case '5':
				this.listHouses();
				break;
			case '6':
				this.exit();
				break;
			default:
				System.out.println("输入有误");
			}

		} while (loop);

	}

}
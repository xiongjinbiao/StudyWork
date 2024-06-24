package demo04.houseRent.service;

import demo04.houseRent.domain.House;

public class HouseService {

	private House[] houses;
	private int houseNum;
	private int idCounter;

	public HouseService(int size) {
		houses = new House[size];
//		houses[0] = new House(1, "jack", "112", "海淀区", 2000, "未出租");
	}

	public House[] list() {
		return houses;
	}

	public boolean add(House house) {
		if (houseNum == houses.length) {
			System.out.println("房屋满了，不能再添加");
			return false;
		}
		houses[houseNum++] = house;
		house.setId(++idCounter);
		return true;
	}

	public boolean del(int delId) {
		int index = -1;
		for (int i = 0; i < houseNum; i++) {
			if (delId == houses[i].getId()) {
				index = i;
			}
		}

		if (index == -1) {
			return false;
		}

		for (int i = index; i < houseNum - 1; i++) {
			houses[i] = houses[i + 1];
		}
		houses[--houseNum] = null;
		return true;

	}

	public House findById(int findId) {
		for (int i = 0; i < houseNum; i++) {
			if (findId == houses[i].getId()) {
				return houses[i];
			}
		}
		return null; 
	}

}
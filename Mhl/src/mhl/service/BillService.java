package mhl.service;

import java.util.List;
import java.util.UUID;

import mhl.dao.BillDAO;
import mhl.domain.Bill;

public class BillService {

	private MenuService menuService = new MenuService();
	private BillDAO billDAO = new BillDAO();
	private DiningTableService diningTableService = new DiningTableService();

	/**
	 * 点餐之后加入一条信息到点餐表
	 * 
	 * @param menuId
	 * @param nums
	 * @param diningTableId
	 * @return
	 */
	public boolean orderMenu(int menuId, int nums, int diningTableId) {

		String billId = UUID.randomUUID().toString();
		int row = billDAO.update("insert into bill values(null, ?, ?, ?, ?, ?, now(), '未结账')", billId, menuId, nums,
				menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
		if (row <= 0) {
			return false;
		}

		return diningTableService.updateDiningTableState(diningTableId, "就餐中");

	}

	/**
	 * 返回订单
	 * 
	 * @return
	 */
	public List<Bill> list() {
		List<Bill> list = billDAO.queryMulti("select * from bill", Bill.class);
		return list;
	}

	/**
	 * 查看餐桌是否有未结账的订单
	 * 
	 * @param diningTableId
	 * @return
	 */
	public boolean hasPayBillByDiningTableId(int diningTableId) {
		Bill bill = billDAO.querySingle("select * from bill wherer diningTableId = ? and state = '未结账' ", Bill.class,
				diningTableId);
		return bill != null ? true : false;
	}

	/**
	 * 结账完之后修改订单支付状态和餐桌的状态
	 * 
	 * @param diningTableId
	 * @param payMode
	 * @return
	 */
	public boolean payBill(int diningTableId, String payMode) {

		// 修改bill表
		int row = billDAO.update("update bill set state = ? where diningTableId = ? and state = '未结账'", payMode,
				diningTableId);
		if (row <= 0) {
			return false;
		}

		// 修改diningTable表
		if (!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
			return false;
		}
		return true;

	}

}

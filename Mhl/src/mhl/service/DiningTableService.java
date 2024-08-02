package mhl.service;

import java.util.List;

import mhl.dao.DiningTableDAO;
import mhl.domain.DiningTable;

public class DiningTableService {

	private DiningTableDAO diningTableDAO = new DiningTableDAO();

	/**
	 * @return 所有的餐桌状态
	 */
	public List<DiningTable> list() {
		List<DiningTable> list = diningTableDAO.queryMulti("select id, state from diningTable", DiningTable.class);
		return list;
	}

	/**
	 * 根据餐桌id获取餐桌
	 * 
	 * @param id
	 * @return
	 */
	public DiningTable getDiningTableById(int id) {
		DiningTable diningTable = diningTableDAO.querySingle("select * from diningTable where id = ?",
				DiningTable.class, id);
		return diningTable;
	}

	/**
	 * 预定餐桌后更新餐桌状态
	 * 
	 * @param id
	 * @param orderName
	 * @param orderTel
	 * @return
	 */
	public boolean orderDiningTable(int id, String orderName, String orderTel) {
		int row = diningTableDAO.update(
				"update diningTable set state = '已预订', orderName = ?, orderTel = ? where id = ? ", orderName, orderTel,
				id);
		return row > 0 ? true : false;
	}

	/**
	 * 点餐成功后，更新餐桌状态
	 * 
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean updateDiningTableState(int id, String state) {
		int row = diningTableDAO.update("update diningTable set state = ? where id = ?", state, id);
		return row > 0 ? true : false;
	}
	
	public boolean updateDiningTableToFree(int id, String state) {
		int row = diningTableDAO.update("update diningTable set state = ?, orderName = ' ', orderTel = ' ' where id = ?", state, id);
		return row > 0 ? true : false;
	}
	
}

package mhl.service;

import java.util.List;

import mhl.dao.MenuDAO;
import mhl.domain.Menu;

public class MenuService {

	private MenuDAO menuDAO = new MenuDAO();

	/**
	 * @return 所有菜品
	 */
	public List<Menu> list() {
		List<Menu> list = menuDAO.queryMulti("select * from menu", Menu.class);
		return list;
	}

	public Menu getMenuById(int id) {
		Menu menu = menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
		return menu;
	}

}

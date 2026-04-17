package it.unibs.ingsw.view;

import java.util.HashMap;
import it.unibs.ingsw.view.menu.*;

public class AppView {
	
	HashMap<MenuType, Menu> menuList;
	public void start() {
		menuList = new HashMap<MenuType, Menu>();
		menuList.put(MenuType.FIRST_LOGIN, new FirstLoginMenu());
	}
}

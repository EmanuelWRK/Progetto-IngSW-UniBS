package it.unibs.ingsw.view.menu;

import it.unibs.ingsw.view.menu.menus.*;

public class MenuFactory {

	public static Menu createMenu(MenuType menuType) {
		
		switch(menuType) {
			case LOGIN: return new LoginMenu();
			default: throw new IllegalArgumentException();
		}
	}
}

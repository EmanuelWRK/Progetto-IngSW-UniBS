package it.unibs.ingsw.view.menu;

import it.unibs.ingsw.view.menu.menus.*;

public class MenuFactory {
	//Creazione Menu
	public static Menu createMenu(MenuType menuType) {
		//Scelta tipo di Menu
		switch(menuType) {
			case LOGIN:
				return new LoginMenu();
			
			default: throw new IllegalArgumentException();
		}
	}
}

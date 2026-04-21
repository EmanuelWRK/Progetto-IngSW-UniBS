package it.unibs.ingsw.view;

import it.unibs.ingsw.view.menu.*;

public class AppView {
	
	public void start() {
		MenuFactory.createMenu(MenuType.LOGIN).printMenu();
	}
}

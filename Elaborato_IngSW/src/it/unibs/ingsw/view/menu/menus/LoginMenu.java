package it.unibs.ingsw.view.menu.menus;

import it.unibs.ingsw.view.menu.Menu;

public class LoginMenu extends Menu {
	
	@Override
	/**
	 * Visualizzazione del menù
	 */
	public void printMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append(DIVIDER);
		sb.append(NEWLINE);
		sb.append("LOGIN MENU");
		System.out.print(sb.toString());
	}
}

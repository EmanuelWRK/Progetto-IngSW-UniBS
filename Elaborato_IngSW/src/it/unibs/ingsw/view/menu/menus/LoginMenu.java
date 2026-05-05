package it.unibs.ingsw.view.menu.menus;

import it.unibs.ingsw.view.menu.Menu;


public class LoginMenu extends Menu {
	private static final String MENU_TYPE = "LOGIN MENU"; //Usare enum

	@Override
	/**
	 * Visualizzazione del menù
	 */
	public void printHeader() {
		StringBuffer sb = new StringBuffer();
		sb.append(DIVIDER);
		sb.append(NEWLINE);
		sb.append(TAB);
		sb.append(MENU_TYPE);
		sb.append(NEWLINE);
		sb.append(DIVIDER);
		sb.append(NEWLINE);
		System.out.print(sb.toString());
	}
	
}

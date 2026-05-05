package it.unibs.ingsw.view.menu.menus;

import it.unibs.ingsw.view.menu.Menu;


public class LoginMenu extends Menu {
	private static final String MENU_TYPE = "LOGIN MENU"; //Usare enum

	@Override
	/**
	 * Visualizzazione del menù
	 */
	public void printMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append(DIVIDER);
		sb.append(NEWLINE);
		sb.append(TAB);
		sb.append(MENU_TYPE);
		sb.append(NEWLINE);
		System.out.print(sb.toString());
		System.out.println("1. Inserisci username: ");
		
	}
	
}

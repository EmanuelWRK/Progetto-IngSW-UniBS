package it.unibs.ingsw.view.menu.menus;

import it.unibs.ingsw.view.menu.Menu;

public class LoginMenu extends Menu {
	private static final String TAB = "\t";
	private static final String SEPARATORE = "---------------------------";
	private static final Object A_CAPO = "\n";

	@Override
	public void printMenu() {
		System.out.println(toString());
	}
	
	//toSTRING
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(SEPARATORE);
		sb.append(A_CAPO);
		sb.append(TAB);
		sb.append("LOGIN MENU");
		return sb.toString();
	}
}

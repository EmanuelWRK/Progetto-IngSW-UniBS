package it.unibs.ingsw.view.menu.menus;

import it.unibs.ingsw.view.menu.Menu;
import it.unibs.ingsw.view.menu.MenuType;

public class SignupMenu extends Menu {
	private static final MenuType menuType = MenuType.SIGNUP;
	
	/**
	 * Visualizzazione del menù
	 */
	public void printHeader() {
		StringBuffer sb = new StringBuffer();
		sb.append(DIVIDER);
		sb.append(NEWLINE);
		sb.append(TAB);
		sb.append(menuType.name);
		sb.append(NEWLINE);
		sb.append(DIVIDER);
		sb.append(NEWLINE);
		System.out.print(sb.toString());
	}

	@Override
	public void printOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseOption(int option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MenuType getMenutype() {
		return menuType;
	}
}

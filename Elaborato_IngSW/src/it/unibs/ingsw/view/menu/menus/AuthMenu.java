package it.unibs.ingsw.view.menu.menus;

import it.unibs.ingsw.view.menu.Menu;
import it.unibs.ingsw.view.menu.MenuType;

public class AuthMenu extends Menu {
	private static final MenuType menuType = MenuType.AUTH;
	private static final String[] options = {"Login", "Signup"};
	
	@Override
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
		for(int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ": " + options[i]);
		}
	}

	@Override
	public void chooseOption(int option) {
		
	}

	@Override
	public MenuType getMenutype() {
		return menuType;
	}

}

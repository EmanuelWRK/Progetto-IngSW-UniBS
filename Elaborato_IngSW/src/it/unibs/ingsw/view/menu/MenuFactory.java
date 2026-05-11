package it.unibs.ingsw.view.menu;

import it.unibs.ingsw.view.menu.menus.*;

public class MenuFactory {
	/**
	 * Metodo che restituisce l'oggetto di tipo Menu
	 * @param menuType Tipo di menù richiesto
	 * @return Il tipo di menù richiesto
	 */
	public static Menu createMenu(MenuType menuType) {
		switch(menuType) {
			case LOGIN:
				return new LoginMenu();
			case AUTH:
				return new AuthMenu();
			case SIGNUP:
				return new SignupMenu();
			default: throw new IllegalArgumentException();
		}
	}
}

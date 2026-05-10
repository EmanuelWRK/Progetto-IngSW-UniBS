package it.unibs.ingsw.view;

import java.util.Scanner;

import it.unibs.ingsw.view.menu.*;

public class AppView {
	private static Scanner userInteraction = new Scanner(System.in);
	private Menu currentMenu;
	
	public void start() { 
		setCurrentMenu(MenuType.AUTH);
		showMenu();
	}
	
	public void showMenu() {
		currentMenu.printHeader();;
	}
	
	public void showMessage(String string) {
		System.out.println(string);
	}
	
	private void setCurrentMenu(MenuType menuType) {
		this.currentMenu = MenuFactory.createMenu(menuType);
	}
	
	public String insertString() {
		String newUsername;
		newUsername = userInteraction.nextLine();
	    return newUsername;
	}
}
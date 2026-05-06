package it.unibs.ingsw.view;

import java.util.Scanner;

import it.unibs.ingsw.view.menu.*;

public class AppView {
	private static Scanner userInteraction = new Scanner(System.in);
	
	public void start() { 
		Menu login = MenuFactory.createMenu(MenuType.LOGIN);
		showMenu(login);
	}
	
	public String insertString() {
		String newUsername;
		newUsername = userInteraction.nextLine();
	    return newUsername;
	}
	
	public void showMenu(Menu menu) {
		menu.printHeader();
	}
	
	public void showMessage(String string) {
		System.out.println(string);
	}
}
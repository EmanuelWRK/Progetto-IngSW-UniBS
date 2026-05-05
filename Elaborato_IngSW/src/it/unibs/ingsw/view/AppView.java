package it.unibs.ingsw.view;

import java.util.Scanner;

import it.unibs.ingsw.view.menu.*;

public class AppView {
	private static Scanner userInteraction = new Scanner(System.in);
	
	public void start() { 
		showLoginMenu();
	}
	
	public static String insertString() {
		String newUsername;
		newUsername = userInteraction.nextLine();
	    return newUsername;
	}
	
	public void showLoginMenu() {
		MenuFactory.createMenu(MenuType.LOGIN).printMenu();
	}
	
	public void showMessage(String string) {
		System.out.println(string);
	}
}
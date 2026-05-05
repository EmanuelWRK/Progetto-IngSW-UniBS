package it.unibs.ingsw.view;

import java.util.Scanner;

import it.unibs.ingsw.view.menu.*;

public class AppView {
	private static Scanner userInteraction = new Scanner(System.in);
	
	public void start() { 
		render();
	}
	
	public static String insertUsername() {
		String newUsername;
		System.out.print("Inserire username: ");
		newUsername = userInteraction.nextLine();
	    return newUsername;
	}
	
	public static void primoAccesso() {
		String username = insertUsername();
		String password = insertPassword();
	}
	
	private static String insertPassword() {
		String password;
		System.out.print("Inserire password: ");
		password = userInteraction.nextLine();
	    return password;
	}

	private void render() {
		MenuFactory.createMenu(MenuType.LOGIN).printMenu();
	}
}
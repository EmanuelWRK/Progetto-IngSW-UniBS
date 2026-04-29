package it.unibs.ingsw.view;

import java.util.Scanner;

import it.unibs.ingsw.view.menu.*;

public class AppView {
	
	Scanner userInteraction = new Scanner(System.in);
	
	public void start() { 
		render();
	}
	
	private void render() {
		MenuFactory.createMenu(MenuType.LOGIN).printMenu();
	}
}

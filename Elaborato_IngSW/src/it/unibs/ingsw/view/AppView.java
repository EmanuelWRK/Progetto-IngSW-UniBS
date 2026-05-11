package it.unibs.ingsw.view;

import java.util.Scanner;

import it.unibs.ingsw.controller.ViewListener;
import it.unibs.ingsw.view.menu.*;

public class AppView {
	private static Scanner userInteraction = new Scanner(System.in);
	private ViewListener listener;
	
	public void setListener(ViewListener listener) {
		this.listener = listener;
	}
	
	public void showAuthMenu() {
        Menu newMenu = MenuFactory.createMenu(MenuType.AUTH);
        
        newMenu.printHeader();
        newMenu.printOptions();
        
        int scelta = insertInt("Scegli un'opzione: ");

        switch(scelta) {
        case 1:
            listener.onEvent(MenuType.LOGIN);
            break;
        case 2:
            listener.onEvent(MenuType.SIGNUP);
            break;

        case 0:
            listener.onEvent(MenuType.EXIT);
            break;
        }
    }
	
	private Menu currentMenu;
	
	
	public void start() { 
//		setCurrentMenu(MenuType.AUTH);
//		render();
//		Menu mainMenu = MenuFactory.createMenu(MenuType.AUTH);
		
	}
	
	public void showMessage(String string) {
		System.out.println(string);
	}
	
	public String insertString(String domanda) {
		showMessage(domanda);
	    return userInteraction.nextLine();
	}
	
	public int insertInt(String domanda) {
		showMessage(domanda);
		int value = Integer.parseInt(userInteraction.nextLine());

	    return value;
	}
	
	public void render() {
		currentMenu.printHeader();
		/**
		 * Differenziazione tra i vari menu
		 */
		switch(currentMenu.getMenutype()){
			case MenuType.AUTH:
				currentMenu.printOptions();
				break;
			case MenuType.LOGIN:
				String username = insertString("Inserire username");
				break;
		default:
			break;
		}
	}
	
	public void setCurrentMenu(MenuType menuType) {
		this.currentMenu = MenuFactory.createMenu(menuType);
	}
	
	public int getUserMenuChoice() {
		return userInteraction.nextInt();
	}
}
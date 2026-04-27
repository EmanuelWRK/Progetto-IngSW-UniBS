package it.unibs.ingsw.controller;

import it.unibs.ingsw.model.AppModel;
import it.unibs.ingsw.view.AppView;
import it.unibs.ingsw.view.menu.Menu;
import it.unibs.ingsw.view.menu.MenuFactory;
import it.unibs.ingsw.view.menu.MenuType;

public class AppController {
	AppModel model;
	AppView view;
	
	public AppController(AppModel model, AppView view) {
		this.model = model;
		this.view = view;
	}
	
	public void start() {
		Menu menu = MenuFactory.createMenu(MenuType.LOGIN);	
		menu.printMenu();
	}
}

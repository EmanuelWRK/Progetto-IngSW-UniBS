package it.unibs.ingsw.controller;

import it.unibs.ingsw.model.AppModel;
import it.unibs.ingsw.view.AppView;

public class AppController {
	AppModel model;
	AppView view;
	
	public AppController(AppModel model, AppView view) {
		this.model = model;
		this.view = view;
	}
	
	public void start() {
		view.start();	
		String username;
		boolean ok = false;
		do {
			username = AppView.insertString();
			ok = AppModel.riempiFile(username);
			if(ok) {
				view.showMessage("Login effettuato");
			}else {
				view.showMessage("Username già esistente!"
						+ "\nInserisci username: ");
			}
		}while(!ok);
	}
	
}

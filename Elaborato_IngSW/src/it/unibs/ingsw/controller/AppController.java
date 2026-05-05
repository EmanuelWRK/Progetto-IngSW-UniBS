package it.unibs.ingsw.controller;

import it.unibs.ingsw.model.AppModel;
import it.unibs.ingsw.view.AppView;

public class AppController {
	private static final String ASK_USERNAME = "Inserisci username: ";
	AppModel model;
	AppView view;
	
	public AppController(AppModel model, AppView view) {
		this.model = model;
		this.view = view;
	}
	
	public void start() {
		view.start();
		String username;
		String password;
		boolean ok = false;
		
		view.showMessage(ASK_USERNAME);
		username = AppView.insertString();
		
		if(username == "admin") {
			primoAccesso();
		}else {
			//Effettivo login
			do {
				ok = AppModel.riempiFileNames(username);
				if(!ok) {
					//Username esiste
//					view.showMessage("Username valido!");
				}else {
					//Username non esiste
					view.showMessage("Username non presente in memoria!\n");
					do {
						username = AppView.insertString();
					}while(username == "admin");
				}
			}while(ok);
			ok = false;
			
			//Inserimento password
			do {
				view.showMessage("Inserisci password: ");
				password = AppView.insertString();
				ok = AppModel.riempiFileUsers(username, password);
				if(ok) {
					
				}else {
					view.showMessage("Password errata!\n");
				}
			}while(!ok);
		}
	}
	
	//Se user ha credenziali predefinite, si creano credenziali personali
	private void primoAccesso() {
		view.showMessage("Primo accesso!\nCreazione nuove credenziali!");
		
		//Setup username
		String username = setUsername();
		//Setup password
		String password = setPassword(username);
		
		AppModel.riempiFileUsers(username, password);
	}
	
	private String setUsername() {
		String username;
		boolean ok = false;
		do {
			view.showMessage(ASK_USERNAME);
			username = AppView.insertString();
			ok = AppModel.riempiFileNames(username);
			if(ok) {
				//true se nuovo username
				view.showMessage("Username valido!");
			}else {
				//false se username esistente
				view.showMessage("Username già esistente!\n");
			}
		}while(!ok);
		return username;
	}
	
	private String setPassword(String username) {
		String password;
		boolean ok = false;
		do {
			view.showMessage("Inserisci password: ");
			password = AppView.insertString();
			//Da implementare controllo per non avere password troppo semplice
		}while(!ok);
		return password;
	}
}

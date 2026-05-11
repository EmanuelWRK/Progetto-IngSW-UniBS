package it.unibs.ingsw.controller;

import it.unibs.ingsw.model.AppModel;
import it.unibs.ingsw.view.AppView;
import it.unibs.ingsw.view.menu.MenuType;
import it.unibs.ingsw.model.utenti.User;

public class AppController implements ViewListener{
	private static final String ASK_USERNAME = "Inserisci username: ";
	AppModel model;
	AppView view;
	
	public AppController(AppModel model, AppView view) {
		this.model = model;
		this.view = view;
		view.setListener(this);
	}
	
	public void start() {
		view.start();
		view.setCurrentMenu(MenuType.AUTH);
	}

	@Override
	public void onEvent(MenuType type) {
        switch(type) {
        case LOGIN:
            primoAccesso();
            break;
        case SIGNUP:
            effettuaLogin();
            break;
        case EXIT:
            System.exit(0);
            break;
		default:
			break;
        }
	}
	
	//Se user ha credenziali predefinite, si creano credenziali personali
	private boolean primoAccesso() {
		view.showMessage("Primo accesso!\nCreazione nuove credenziali!");
		boolean ok = false;
		//Setup username
		String username = setUsername();
		//Setup password
		String password = setPassword(username);
		
		User newUser = new User(username, password);
		
		ok = model.riempiFileUsers(newUser);
		return ok;
	}
	
	private boolean effettuaLogin() {
		String password;
		String username = "";
		boolean ok = false;
		
		do {
			ok = model.riempiFileNames(username);
			if(!ok) {
				//Username esiste
				view.showMessage("Username valido!");
			}else {
				//Username non esiste
				view.showMessage("Username non presente in memoria!\n");
				do {
					view.showMessage(ASK_USERNAME);
					username = view.insertString("");
				}while(username.equals("admin"));
			}
		}while(ok);
		ok = false;
		
		//Inserimento password
		do {
			view.showMessage("Inserisci password: ");
			password = view.insertString("");
			
			ok = model.controlloPassword(password, username);
			if(ok) {
				view.showMessage("Login effettuato!");
			}else {
				view.showMessage("Password errata!\n");
			}
		}while(!ok);
		
		System.out.println(ok);
		return ok;
	}
	
	private String setUsername() {
		String username;
		boolean ok = false;
		do {
			view.showMessage(ASK_USERNAME);
			username = view.insertString("");
			ok = model.riempiFileNames(username);
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
			password = view.insertString("");
			//Da implementare controllo per non avere password troppo semplice
		}while(ok);
		return password;
	}
}

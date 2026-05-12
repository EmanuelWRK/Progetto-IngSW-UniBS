package it.unibs.ingsw.controller;

import it.unibs.ingsw.model.AppModel;
import it.unibs.ingsw.view.AppView;
import it.unibs.ingsw.view.menu.MenuType;
import it.unibs.ingsw.model.utenti.User;

public class AppController implements ViewListener{
	private static final String USERNAME_ESISTENTE = "Username già esistente";
	private static final String PASSWORD_ERRATA = "Password errata";
	private static final String LOGIN_EFFETTUATO = "Login effettuato";
	private static final String USERNAME_INESISTENTE = "Username inesistente!";
	private static final String ASK_PASSWORD = "Inserisci password: ";
	private static final String ASK_USERNAME = "Inserisci username: ";
	
	AppModel model;
	AppView view;
	
	public AppController(AppModel model, AppView view) {
		this.model = model;
		this.view = view;
		view.setListener(this);
	}
	
	public void start() {
		view.showAuthMenu();
//		view.start();
//		view.setCurrentMenu(MenuType.AUTH);
	}

	@Override
	public void onEvent(MenuType type) {
        switch(type) {
        case LOGIN:
            login();//portarlo in Model?
            break;
        case SIGNUP:
            signup();//portarlo in Model?
            break;
        case EXIT:
//            System.exit(0);
            break;
		default:
			break;
        }
	}
	
	private void login() {
		boolean valido = false;
		String username;
		String password; 
		do {
			username = setUsername();
			if(model.userExists(username)) {
				valido = true;
			} else {
				view.showMessage(USERNAME_INESISTENTE);
			}
		}while(!valido);
		
		valido = false;
		do {
			password = setPassword();
			if(model.controlloPassword(username, password)) {
				valido = true;
				view.showMessage(LOGIN_EFFETTUATO);
			} else {
				view.showMessage(PASSWORD_ERRATA);
			}
		}while(!valido);
	}

	private void signup() {
		String username;
		boolean exists;
		do {
		    username = setUsername();
		    exists = model.userExists(username);
		    if(exists) {
		        view.showMessage(USERNAME_ESISTENTE);
		    }
		} while(exists);String password = setPassword();
		
		User newUser = new User(username, password);
		model.addUser(newUser);
	}
	
	private String setUsername() {
		String username = view.insertString(ASK_USERNAME);
	    return username;
	}
	
	//Da implementare controllo per non avere password troppo semplice	
	private String setPassword() {
		String password;
//		boolean valida;
//		do {
			password = view.insertString(ASK_PASSWORD);
//			if(password.length() < 12)
//				valida = false;
//			else valida = true;
//		}while(!valida);
		return password;
	}
}

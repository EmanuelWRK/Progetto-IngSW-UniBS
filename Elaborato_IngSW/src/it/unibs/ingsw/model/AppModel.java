package it.unibs.ingsw.model;

import it.unibs.ingsw.model.utenti.User;
import it.unibs.ingsw.view.AppView;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.File;

public class AppModel {
	private static String username = "admin";
//	private String password = "password";
	private static int scelta = 0;
	
	public static void start() {
		User configuratore = new User(username);

		switch (scelta) {
		case 0: {
			username = AppView.setUsername();
			configuratore.setUsername(username);
			break;
			}
		case 1:{
			break;
		}
		default:
			throw new IllegalArgumentException();
		}
	}

}

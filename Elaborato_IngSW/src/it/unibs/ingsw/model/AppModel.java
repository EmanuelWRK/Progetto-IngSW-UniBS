package it.unibs.ingsw.model;

import it.unibs.ingsw.model.utenti.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class AppModel {
	private String username = "admin";
//	private String password = "password";
	private int scelta = 0;
	
	//TODO Implementare JSON
	
	public void start() {
		User configuratore = new User(username);

		switch (scelta) {
		case 0: {
			configuratore.setUsername();
			
			try {
				ObjectMapper mapper = new ObjectMapper();
				// salva l'oggetto User su file JSON
				mapper.writeValue(new File("user.json"), configuratore);
				System.out.println("User salvato in JSON!");
				} catch (Exception e) {
					e.printStackTrace();
					}
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

package it.unibs.ingsw.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

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
//			username = 
//			configuratore.setUsername(username);
//			break;
			}
		case 1:{
			break;
		}
		default:
			throw new IllegalArgumentException();
		}
	}

	public static boolean riempiFile(String username) {
		boolean esistente = false;
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("user.json");
			List<String> users;
			
			if (file.exists()) {
				users = mapper.readValue(file, new TypeReference<List<String>>() {});
			} else {
				users = new ArrayList<>();
			}
			if (users.contains(username)) {
				System.out.println("Username già esistente!");
				esistente = true;
			} else {
				users.add(username);
				mapper.writeValue(file, users);
				System.out.println("User salvato in JSON!");
				esistente = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esistente;
	}
}

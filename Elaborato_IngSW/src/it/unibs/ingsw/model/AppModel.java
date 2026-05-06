package it.unibs.ingsw.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibs.ingsw.model.utenti.User;

import com.fasterxml.jackson.core.type.TypeReference;

public class AppModel {
	public static boolean riempiFileNames(String newUsername) {
		boolean ok = false;
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("data/usernameList.json");
			List<String> usernames;
			
			if (file.exists()) {
				usernames = mapper.readValue(file, new TypeReference<List<String>>() {});
			} else {
				usernames = new ArrayList<>();
			}
			
			if (usernames.contains(newUsername)) {
				ok = false;
			} else {
				usernames.add(newUsername);
				mapper.writeValue(file, usernames);
				ok = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//false se username è in memoria, true se username è nuovo
		return ok;
	}
	
	public static boolean riempiFileUsers(User newUser) {
		boolean ok = false;
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("data/userList.json");
			List<User> users;
			
			if (file.exists()) {
				users = mapper.readValue(file, new TypeReference<List<User>>() {});
			} else {
				users = new ArrayList<>();
			}
						
			if (users.contains(newUser)) {
				ok = false;
			} else {
				users.add(newUser);
				mapper.writeValue(file, users);
				ok = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//false se username è in memoria, true se username è nuovo
		return ok;
	}
	
	public static boolean controlloPassword(String passwordInserita, String userDaLoggare) {
		int i = 0;
		User utente;
		boolean ok = false;
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("data/userList.json");
			List<User> users;
			
			if (file.exists()) {
				users = mapper.readValue(file, new TypeReference<List<User>>() {});
			} else {
				users = new ArrayList<>();
			}
			
			do {
				utente = users.get(i);
				i++;
			}while(!utente.getUsername().equals(userDaLoggare));
			
			ok = utente.getPassword().equals(passwordInserita);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	public static boolean userEsistente(String username) {
		boolean ok = false;
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("data/usernameList.json");
			List<String> usernames;
			
			if (file.exists()) {
				usernames = mapper.readValue(file, new TypeReference<List<String>>() {});
			} else {
				usernames = new ArrayList<>();
			}
			
			if (usernames.contains(username)) {
				ok = true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		//true se username è in memoria, false se username non esiste
		return ok;
	}
}

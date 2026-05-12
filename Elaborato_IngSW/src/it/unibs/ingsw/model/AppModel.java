package it.unibs.ingsw.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unibs.ingsw.model.utenti.User;
import com.fasterxml.jackson.core.type.TypeReference;

public class AppModel {
	private List<User> loadUsers() {
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        File file = new File("data/userList.json");
	        if(file.exists()) {
	            return mapper.readValue(file,new TypeReference<List<User>>() {});
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return new ArrayList<>();
	}
	
	private void saveUsers(List<User> userList) {
	    try {
	    	//Aggiungere la creazione della cartella data?
//			File directory = new File("data");
//			if(!directory.exists()) {
//				directory.mkdir();
//			}
			
	        ObjectMapper mapper = new ObjectMapper();
	        File file = new File("data/userList.json");
	        mapper.writeValue(file, userList);
	        //Usare writerWithDefaultPrettyPrinter()?
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean addUser(User newUser) {
	    List<User> users = loadUsers();
	    if(userExists(newUser.getUsername())) {
	        return false;
	    }
	    users.add(newUser);
	    saveUsers(users);
	    return true;
	}
	
	public boolean userExists(String username) {
		List<User> users = loadUsers();
		for(User u : users) {
			if(u.getUsername().equals(username)) {
				return true;
			}
		}
	    return false;
	}
	
	public User getUser(String username) {
		List<User> users = loadUsers();
		for(User u : users) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
	    return null;
	}
	
	public boolean controlloPassword(String username, String password) {
		User daControllare = getUser(username);
		//getUser potrebbe tornare null, ma da login c'è controllo
		//Da irrobustire?
		
		if(daControllare.getPassword().equals(password)) {
			return true;
		} else 
			return false;
	}
	
}

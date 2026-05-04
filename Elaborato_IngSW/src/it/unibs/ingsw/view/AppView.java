package it.unibs.ingsw.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


import it.unibs.ingsw.view.menu.*;

public class AppView {
	
	private static Scanner userInteraction = new Scanner(System.in);
	
	public void start() { 
		render();
	}
	
	public static String setUsername() {
		String newUsername;
		boolean esistente = false;
		do {
			System.out.print("Inserire username: ");
			newUsername = userInteraction.nextLine();
			
		    try {
		        ObjectMapper mapper = new ObjectMapper();
		        File file = new File("user.json");
		        
		        List<String> users;
		        
		        if (file.exists()) {
		            users = mapper.readValue(file, new TypeReference<List<String>>() {});
		        } else {
		            users = new ArrayList<>();
		        }
		        
		        if (users.contains(newUsername)) {
		            System.out.println("Username già esistente!");
		            esistente = true;
		        } else {
		        	users.add(newUsername);
			        mapper.writeValue(file, users);
			        System.out.println("User salvato in JSON!");
			        esistente = false;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}while(esistente);
	    return newUsername;
	}
	
	private void render() {
		MenuFactory.createMenu(MenuType.LOGIN).printMenu();
	}
}
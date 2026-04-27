package it.unibs.ingsw.model.utenti;

import java.util.Scanner;

public class User {
	private String username;
	
	public User(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername() {
//		Input username
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Inserire username:");
			String newUsername = input.nextLine();
			
			this.username = newUsername;
		}
	}
	
}
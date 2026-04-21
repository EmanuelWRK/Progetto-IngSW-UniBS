package it.unibs.ingsw.model;

public class AppModel {
	private String user = "admin";
//	private String password = "password";
	private boolean firstAccess = true;
	
	
	public void start() {
		User configuratore = new User();
		
		
	}

	public String getUser() {
		return user;
	}
	
}

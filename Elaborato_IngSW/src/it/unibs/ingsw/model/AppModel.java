package it.unibs.ingsw.model;

public class AppModel {
	private String username = "admin";
//	private String password = "password";
	private int scelta = 0;
	
	public void start() {
		User configuratore = new User(username);
		

		switch (scelta) {
		case 0: {
			configuratore.setUsername();
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

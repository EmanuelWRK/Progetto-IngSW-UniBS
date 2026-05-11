package it.unibs.ingsw.view.menu;

public enum MenuType {
	AUTH("Authentication Menu"), LOGIN("Login"), SIGNUP("Signup"), EXIT("Exit");

	public String name;
	
	MenuType(String name) {
		this.name = name;
	}
}

package it.unibs.ingsw.view.menu;

public enum MenuType {
	AUTH("Authentication Menu"), LOGIN("Login");

	public String name;
	
	MenuType(String name) {
		this.name = name;
	}
}

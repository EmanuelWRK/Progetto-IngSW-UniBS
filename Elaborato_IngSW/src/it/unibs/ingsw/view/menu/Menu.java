package it.unibs.ingsw.view.menu;

public abstract class Menu {
	protected static final String TAB = "\t";
	protected static final String DIVIDER = "====================================================";
	protected static final String NEWLINE = "\n";
	
	public abstract void printHeader();
	public abstract void printOptions();
	public abstract void chooseOption(int option);
	public abstract MenuType getMenutype();
}
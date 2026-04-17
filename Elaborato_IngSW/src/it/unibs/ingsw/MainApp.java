package it.unibs.ingsw;

import it.unibs.ingsw.view.AppView;
import it.unibs.ingsw.model.AppModel;

public class MainApp {

	private AppView view;
	private AppModel model;
	
	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.initialize();
	}

	public MainApp() {
		this.model = new AppModel();
		this.view = new AppView();
	}

	private void initialize() {
		model.start();
		view.start();
	}
}
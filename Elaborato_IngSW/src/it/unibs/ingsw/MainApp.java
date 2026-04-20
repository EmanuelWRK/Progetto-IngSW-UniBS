package it.unibs.ingsw;

import it.unibs.ingsw.view.AppView;
import it.unibs.ingsw.model.AppModel;
import it.unibs.ingsw.controller.AppController;

public class MainApp {

	private AppView view;
	private AppModel model;
	private AppController controller;
	
	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.initialize();
	}

	public MainApp() {
		this.model = new AppModel();
		this.view = new AppView();
		this.controller = new AppController(this.model, this.view);
	}

	private void initialize() {
		while(true) {
			controller.start();
		}
	}
}
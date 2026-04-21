package it.unibs.ingsw;

import it.unibs.ingsw.view.AppView;
import it.unibs.ingsw.model.AppModel;
import it.unibs.ingsw.controller.AppController;

public class MainApp {
	
	private AppModel model;
	private AppView view;
	private AppController controller;
	
	public static void main(String[] args) {
		//Creazione dell'istanza principale dell'applicazione
		MainApp app = new MainApp();
		
		//Avvio del programma
		app.initialize();
	}

	//Inizializzazione VMC
	public MainApp() {
		this.model = new AppModel();
		this.view = new AppView();
		this.controller = new AppController(this.model, this.view);
	}

	private void initialize() {
		int i = 0;
		while(i == 0) {
			controller.start();
			i++;
		}
	}
}
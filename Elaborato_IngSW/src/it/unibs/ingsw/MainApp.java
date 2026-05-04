package it.unibs.ingsw;

import it.unibs.ingsw.view.AppView;
import it.unibs.ingsw.model.AppModel;
import it.unibs.ingsw.controller.AppController;

public class MainApp {
	
	private static final String ERROR = "Errore rilevato, chiusura applicazione.\n";
	
	private AppModel model;
	private AppView view;
	private AppController controller;
	
	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.initialize();
		AppModel.start();
	}

	/**
	 * Crea l'istanza dell'applicazione
	 */
	public MainApp() {
		this.model = new AppModel();
		this.view = new AppView();
		this.controller = new AppController(this.model, this.view);
	}

	/**
	 * Avvio del programma
	 */
	private void initialize() {
		try {
			controller.start();
		} catch(Exception e) {
			System.out.println(ERROR);
			e.printStackTrace();
		}
	}
}
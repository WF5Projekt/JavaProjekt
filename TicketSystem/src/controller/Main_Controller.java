package controller;

import views.Main_View;

public class Main_Controller {

	private Main_View MainView;
	
	public Main_Controller(){
		this.MainView  = new Main_View();
		
		this.MainView.setVisible(true);
	}
	
	
}

package controller;


import javax.swing.JOptionPane;

import views.Main_View;

public class Main_Controller {

	private Main_View MainView;
	
	public Main_Controller(){
		try{
			this.MainView  = new Main_View();
			this.MainView.setTab(new Customer_Controller().getTab());
			
			

			this.MainView.setVisible(true);
			
		}catch (Exception e) {
			JOptionPane.showInputDialog("main");
		}
	}
	
	
}

package controller;

import models.Database_Operations;
import models.Mitarbeiter;

public class Main {
	
	public static Login_Controller LoginController;
	public static Main_Controller MainController;
	


	public static void main(String[] args) {

		Login_Controller controller = new Login_Controller();
	}

	public static void setMain(Mitarbeiter user) {
		
		Main_Controller controller = new Main_Controller(user);

	}

}

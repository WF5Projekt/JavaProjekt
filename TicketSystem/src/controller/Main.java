package controller;

import models.Mitarbeiter;

public class Main {
	

	public static void main(String[] args) {

		new Login_Controller();
	}

	public static void setMain(Mitarbeiter user) {
		
		new Main_Controller(user);

	}

}

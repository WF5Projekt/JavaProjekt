package controller;

import java.awt.EventQueue;

import models.Login_Model;

import views.Login_View;



public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_View LoginView = new Login_View();
					Login_Model LoginModel = new Login_Model();
					Login_Controller LoginController = new Login_Controller(LoginView, LoginModel);
					LoginView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Login_Model;
import views.Login_View;

public class Login_Controller {

	private Login_View loginView;
	private Login_Model loginModel;
	
	public Login_Controller(Login_View loginView, Login_Model loginModel) {
		this.loginView = loginView;
		this.loginModel = loginModel;
	
		this.loginView.addLoginListener(new LoginListener());
	}
	
	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try{
				
					loginModel.setUsername(loginView.getTxt_username());
					loginModel.setPasswort(loginView.getTxt_passwort());
					loginModel.login();
					
			}
			catch(Exception e){
				JOptionPane.showInputDialog(this, e);
			}

		}
		
	}
	
	
}

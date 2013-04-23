package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import models.Login_Model;
import views.Login_View;

//Login_Controller erstellt das LoginModel und LoginView und macht die View sichtbar.
//Wenn der Nutzer den Login-Button drückt, liefert login() True oder False um die View wieder auszublenden.
public class Login_Controller{

	private Login_View loginView;
	private Login_Model loginModel;

	public Login_Controller(){

		this.loginView = new Login_View();
		this.loginModel = new Login_Model();
		
		//Listener für Enter-Taste und Login-Button
		this.loginView.addKeyListener(new LoginKeyListener());
		this.loginView.addLoginListener(new LoginListener());
		this.loginView.setVisible(true);
	
	}
	
	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				loginModel.setUsername(loginView.getTxt_username());
				loginModel.setPasswort(loginView.getTxt_passwort());
				
				boolean login = loginModel.login();
				if(login){
					Main.setMain();
					loginView.dispose();
				}
				
			} catch (Exception e) {
				JOptionPane.showInputDialog(this, e);
			}

		}

	}

	class LoginKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent key) {
			if (key.getKeyCode() == KeyEvent.VK_ENTER) {
				try {
					loginModel.setUsername(loginView.getTxt_username());
					loginModel.setPasswort(loginView.getTxt_passwort());

					boolean login = loginModel.login();
					if(login){
						Main.setMain();
						loginView.dispose();
					}
					

				} catch (Exception e) {
					JOptionPane.showInputDialog(this, e);
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	
}

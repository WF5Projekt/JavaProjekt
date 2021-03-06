package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

import models.Database_Operations;
import models.Mitarbeiter;
import views.Login_View;

//Login_Controller erstellt das LoginModel und LoginView und macht die View sichtbar.
//Wenn der Nutzer den Login-Button dr�ckt, liefert login() True oder False um die View wieder auszublenden.
public class Login_Controller {

	private Login_View loginView;
	private Database_Operations db = new Database_Operations();
	
	
	public Login_Controller() {
		this.loginView = new Login_View();

		// Listener f�r Enter-Taste und Login-Button
		this.loginView.addKeyListener(new LoginKeyListener());
		this.loginView.addLoginListener(new LoginListener());
		this.loginView.setVisible(true);
	}
	
	
	public void kill() {
		this.loginView.dispose();
	}

	public void login(){
		try{
		//Wenn felder leer sind -> True -> Fehler
		if(loginView.leereFelder()){
			JOptionPane.showMessageDialog(null, "Bitte Passwort und Username eingeben!",
					"Fehler", JOptionPane.PLAIN_MESSAGE);
		}
		else{
			Mitarbeiter user = db.login( loginView.getTxt_username(), loginView.getTxt_passwort() );
			
			if(user != null){
				kill();
				Main.setMain(user);
			}
		}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fehler bei Login - Daten einlesen/login() aufruf");
			}
		}

	
	
	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			login();
		}

	}

	class LoginKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent key) {
			if (key.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
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

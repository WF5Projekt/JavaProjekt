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
					loginModel.setPasswort(MD5(loginView.getTxt_passwort()));
					loginModel.login();
					
			}
			catch(Exception e){
				JOptionPane.showInputDialog(this, e);
			}

		}
		
	}
	public String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    	JOptionPane.showInputDialog(null, "MD5 Fehler");
		    }
		    return null;
		}
	
}

package models;

import java.sql.*;
import javax.swing.*;

public class Login_Model extends Database_Model {

	public String username;
	public String passwort;
	private String username_eingabe;
	private String passwort_eingabe;
	private String vorname;


	//Im Login werden die eingegebenen Daten an die Datenbank geschickt und überprüft ob User vorhanden ist/ PW korrekt ist.
	public void login() {

		try {
			Connection con = getConnection();
			
			Statement query = con.createStatement();
            String sql = "SELECT * FROM `mitarbeiter` WHERE `username` = '"+this.username_eingabe+"' AND `passwort` = '"+this.passwort_eingabe+"'";

            ResultSet result = query.executeQuery(sql);

            while (result.next()) {
            	this.username = result.getString("username");
				this.passwort = result.getString("passwort");
				this.vorname = result.getString("vorname");
				
            }
            JOptionPane.showMessageDialog(null, this.passwort_eingabe);
            query.close();
			con.close();
			if (this.username_eingabe.equals(this.username)
					&& this.passwort_eingabe.equals(this.passwort)) {
				//--> Hier das Programm starten
				JOptionPane.showMessageDialog(null, "Hallo " + this.vorname
						+ ", du bist jetzt eingeloggt!");
			} else {

			
				JOptionPane.showMessageDialog(null,
						"Username oder Passwort falsch!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Fehler bei LoginMethode...");
		}
	}
	
	//Setter werden von Controller genutzt um dem LoginModel die Daten zu übergeben (welche von der View kommen)
	public void setUsername(String username){
		this.username_eingabe = username;
	}
	public void setPasswort(String passwort){
		this.passwort_eingabe = passwort;
	}
}


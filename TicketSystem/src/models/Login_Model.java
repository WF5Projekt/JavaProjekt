package models;

import java.sql.*;
import javax.swing.*;

public class Login_Model extends Database_Model {

	private String username;
	private String passwort;
	private String username_eingabe;
	private String passwort_eingabe;
	private String idMitarbeiter;
	private Mitarbeiter user;

	// Userdaten werden an die SQL Datenbank geschickt und mit den in der View
	// eingegebenen Daten verglichen.
	// wenn Userdaten korrekt sind liefert Login() "FALSE" -> Login_View wird
	// ausgeblendet
	// wenn Userdaten falsch sind liefert login() "TRUE" -> Login_View bleibt
	// sichtbar. (siehe Login_Controller)

	public boolean login() {
		boolean login = false;
		try {
			Connection con = getConnection();

			Statement query = con.createStatement();
			String sql = "SELECT * FROM `mitarbeiter` WHERE `username` = '"
					+ this.username_eingabe + "' AND `passwort` = '"
					+ this.passwort_eingabe + "'";

			ResultSet result = query.executeQuery(sql);

			while (result.next()) {
				this.username = result.getString("username");
				this.passwort = result.getString("passwort");
				this.idMitarbeiter = result.getString("idMitarbeiter");

			}
			query.close();
			con.close();
			if (this.username_eingabe.equals(this.username)
					&& this.passwort_eingabe.equals(this.passwort)) {
				
				user = new Mitarbeiter(idMitarbeiter);
				
				login = true;
			} else {

				JOptionPane.showMessageDialog(null,
						"Username oder Passwort falsch!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Fehler bei LoginMethode...");

		}
		return login;
	}

	// Setter werden von Controller genutzt um dem LoginModel die Daten zu
	// übergeben (welche von der View kommen)
	public void setUsername(String username) {
		this.username_eingabe = username;
	}

	public void setPasswort(String passwort) {
		this.passwort_eingabe = passwort;
	}
	
	public Mitarbeiter getUser(){
		return this.user;
	}
}

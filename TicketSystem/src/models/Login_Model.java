
		fireTableDataChanged();
		fireTableDataChanged();
		fireTableDataChanged();
		fireTableDataChanged();
		fireTableDataChanged();case "Status":
			if(t.status.toUpperCase().matches("(.*)"+suche.toUpperCase()+"(.*)"))
				searchList.add(t);
			break;
		case "Status":
			if(t.status.toUpperCase().matches("(.*)"+suche.toUpperCase()+"(.*)"))
				searchList.add(t);
			break;
		case "Status":
			if(t.status.toUpperCase().matches("(.*)"+suche.toUpperCase()+"(.*)"))
				searchList.add(t);
			break;
		case "Status":
			if(t.status.toUpperCase().matches("(.*)"+suche.toUpperCase()+"(.*)"))
				searchList.add(t);
			break;
		e models;

import java.sql.*;
import javax.swing.*;

public class Login_Model extends Database_Model {

	private String username_eingabe;
	private String passwort_eingabe;
	private Mitarbeiter user;

	// Userdaten werden an die SQL Datenbank geschickt und mit den in der View
	// eingegebenen Daten verglichen.
	// wenn Userdaten korrekt sind liefert Login() "FALSE" -> Login_View wird
	// ausgeblendet
	// wenn Userdaten falsch sind liefert login() "TRUE" -> Login_View bleibt
	// sichtbar. (siehe Login_Controller)

	public boolean login() {
		boolean login = false;
		String ergebnis = "";
		try {
			Connection con = getConnection();

			Statement query = con.createStatement();
			String sql = "SELECT login_ma('"
					+ this.username_eingabe + "','"
					+ this.passwort_eingabe + "')";

			ResultSet result = query.executeQuery(sql);

			while (result.next()) {
				ergebnis = result.getString(1);
			}
			query.close();
			con.close();
			
			if (ergebnis.equals("fehler"))
			{
				JOptionPane.showMessageDialog(null,
						"User nicht vorhanden!", "Error",
						JOptionPane.ERROR_MESSAGE);
			} 
			else if(ergebnis.equals("falsch"))
			{
				JOptionPane.showMessageDialog(null,
						"Passwort falsch!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else if(!ergebnis.equals("")){
				user = new Mitarbeiter(ergebnis);
				login = true;
				
			}
			else{
				JOptionPane.showMessageDialog(null,
						"Fehler beim Login!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Fehler bei LoginMethode...");

		}
		return login;
	}

	// Setter werden von Controller genutzt um dem LoginModel die Daten zu
	// �bergeben (welche von der View kommen)
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

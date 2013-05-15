package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Mitarbeiter extends Database_Model {
	public String idMitarbeiter;
	public String nachname;
	public String vorname;
	public String standort;
	public String geburt;
	public String email;
	public String telefon;
	public String username;
	public String abteilung;
	
	public Mitarbeiter(String idMitarbeiter, String nachname, String vorname,
		String standort, String geburt, String email,
			String telefon, String username, String abteilung) {
		this.idMitarbeiter = idMitarbeiter;
		this.nachname = nachname;
		this.vorname = vorname;
		this.standort = standort;
		this.geburt = geburt;
		this.email = email;
		this.telefon = telefon;
		this.username = username;
		this.abteilung = abteilung;
	}
	public Mitarbeiter(String idMitarbeiter){
		this.idMitarbeiter = idMitarbeiter;
	}
	

	// Rufe Kundentabelle von Datenbank ab und bilde Customer-Array customers
	public static ArrayList<Mitarbeiter> all() {

		Connection con = getConnection();
		ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();

		Statement query;
		try {
			query = con.createStatement();
			String sql = "select * FROM `allmitarbeiter` ORDER BY idMitarbeiter";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Cusomter
			// mit Methode...
			while (result.next()) {
				mitarbeiter.add(getMitarbeiterWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei Mitarbeiter-all()");
		}
		return mitarbeiter;
	}

	// Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Kunde
	private static Mitarbeiter getMitarbeiterWithResultSet(ResultSet result) {

		Mitarbeiter newMitarbeiter = null;

		try {
			String idMitarbeiter = result.getString("idMitarbeiter");
			String nachname = result.getString("nachname");
			String vorname = result.getString("vorname");
			String standort = result.getString("Standort");
			String geburt = result.getString("Geb.Datum");
			String email = result.getString("E-Mail");
			String telefon = result.getString("Telefonnr.");
			String username = result.getString("Username");
			String abteilung = result.getString("Abteilung");
			
			newMitarbeiter = new Mitarbeiter(idMitarbeiter, nachname, vorname, standort, geburt, email, telefon, username, abteilung);

		} catch (SQLException e) {
			JOptionPane
					.showInputDialog("Fehler in Mitarbeitern_getMitarbeiterWithResultSet");
		}

		return newMitarbeiter;

	}

	//
	public Object[] toJTableArray() {
		Object[] mitarbeiterAttributeArray = { 	
		this.idMitarbeiter,
		this.nachname,
		this.vorname,
		this.geburt,
		this.email,
		this.telefon,
		this.username,
		this.abteilung,
		this.standort
		};
		return mitarbeiterAttributeArray;
	}
	
	

	// Speichern der Tabelle

	public void save() {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "UPDATE mitarbeiter SET " + 
			"idMitarbeiter = '" + this.idMitarbeiter + 
			"', nachname = '" + this.nachname + 
			"', vorname = '" + this.vorname + 
			"', gebdatum = '"+ this.geburt + 
			"', email = '"+ this.email + 
			"', telefon = '"+ this.telefon + 
			"', username = '"+ this.username 
			
			+"' WHERE idMitarbeiter = '"
			+ this.idMitarbeiter + "';";

			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Lösche Kunde
	public void delete() {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "DELETE FROM mitarbeiter " + "WHERE idMitarbeiter = '"
					+ this.idMitarbeiter + "';";
			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.nachname + ", " + this.vorname;
	}
}

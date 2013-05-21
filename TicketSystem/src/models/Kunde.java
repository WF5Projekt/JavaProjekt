package models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Kunde extends Database_Model {




	public String idKunde;
	public String nachname;
	public String vorname;
	public String strasse;
	public String stadt;
	public String idStadt;
	public String geburt;
	public String email;
	public String telefon;
	public String username;
	public String passwort;
	
	

	public Kunde(String idKunde, String nachname, String vorname,
			String strasse, String stadt, String idStadt, String geburt,
			String email, String telefon, String username, String passwort) {
		this.idKunde = idKunde;
		this.nachname = nachname;
		this.vorname = vorname;
		this.strasse = strasse;
		this.stadt = stadt;
		this.idStadt = idStadt;
		this.geburt = geburt;
		this.email = email;
		this.telefon = telefon;
		this.username = username;
		this.passwort = passwort;
	}
	public Kunde(String nachname, String vorname,
			String strasse, String stadt, String idStadt, String geburt,
			String email, String telefon, String username, String passwort) {
		this.nachname = nachname;
		this.vorname = vorname;
		this.strasse = strasse;
		this.stadt = stadt;
		this.idStadt = idStadt;
		this.geburt = geburt;
		this.email = email;
		this.telefon = telefon;
		this.username = username;
		this.passwort = passwort;
	}
	// Rufe Kundentabelle von Datenbank ab und bilde Customer-Array customers
	public static ArrayList<Kunde> all() {

		Connection con = getConnection();
		ArrayList<Kunde> customers = new ArrayList<Kunde>();

		Statement query;
		try {
			query = con.createStatement();
			String sql = "select * FROM `allkunden` ORDER BY idKunde";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Customer
			// mit Methode...
			while (result.next()) {
				customers.add(getCustomersWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei Kunden-all()");
		}
		return customers;
	}

	public static ArrayList<Kunde> search(String spalte, String suche){
		Connection con = getConnection();
		ArrayList<Kunde> customers = new ArrayList<Kunde>();

		Statement query;
		try {
			query = con.createStatement();

			String sql = "call search( 'kunden', '" + spalte + "', '"+ suche +"')";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Kunden
			// mit Methode...
			while (result.next()) {
				customers.add(getCustomersWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei Kunden-Suche)");
		}
		return customers;
			
	}
	
	// Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Kunde
	private static Kunde getCustomersWithResultSet(ResultSet result) {

		Kunde newCustomer = null;

		try {
			String idKunde = result.getString(0); // getString(1)
			String nachname = result.getString("nachname"); //getString(2)
			String vorname = result.getString("vorname");
			String strasse = result.getString("strasse");
			String stadt = result.getString("stadt");
			String idStadt = result.getString("idStadt");
			String geburt = result.getString("Geb.Datum");
			String email = result.getString("Email");
			String telefon = result.getString("Telefonnr");
			String username = result.getString("Username");
			
			newCustomer = new Kunde(idKunde, nachname, vorname, idStadt, strasse, stadt, geburt, email, telefon, username);

		} catch (SQLException e) {
			JOptionPane
					.showInputDialog("Fehler in Kunden_getCustomerWithResultSet");
		}

		return newCustomer;

	}

	//
	public Object[] toJTableArray() {
		Object[] customerAttributeArray = { 
				this.idKunde,
				this.nachname,
				this.vorname,
				this.strasse,
				this.stadt,
				this.geburt,
				this.email,
				this.telefon,
				this.username};
		return customerAttributeArray;
	}
	
	

	// Speichern der Tabelle

	public void save() {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "UPDATE kunde SET " 
					+ "idKunde = '" + this.idKunde + "', " 
					+ "nachname = '" + this.nachname + "', "
					+ "vorname = '" + this.vorname + "', "
					+ "strasse = '" + this.strasse + "', "
					+ "idStadt = '" + this.idStadt + "', "
					+ "geburt = '" + this.geburt + "', "
					+ "email = '" + this.email + "', "
					+ "telefon = '" + this.telefon + "', "
					+ "username = '" + this.username +
					"' WHERE idKunde = '" + this.idKunde + "';";
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
			String query = "DELETE FROM kunde " + "WHERE idKunde = '"
							+ this.idKunde + "';";
			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//Neuen Kunde in Datenbank anlegen
	
	/*
	`newKunde`(
	adresse VARCHAR(50),
	nachname VARCHAR(45),
	vorname VARCHAR(45),
	gebdatum DATE,
	username VARCHAR(45),
	passwort VARCHAR(45),
	email VARCHAR(45),
	telefon INT(45),
	idStadt INT(11))
	 */
	public void newKunde(){
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "call newKunde('" 
					+ this.strasse + "', '" 
					+ this.nachname + "', '"
					+ this.vorname + "', '"
					+ this.geburt + "', '"
					+ this.username + "', '"
					+ this.passwort + "', '"
					+ this.email + "', '"
					+ this.telefon + "', '"
					+ this.idStadt + "')";
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

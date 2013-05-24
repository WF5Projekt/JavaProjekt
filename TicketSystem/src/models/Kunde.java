package models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Kunde extends Database_Model {

	public String idKunde;
	public String name;
	public String geburtstag;
	public String strasse;
	public String hausnummer;
	public String plz;
	public String ort;
	public String land;
	
	public String erreichbar;
	public String idAccount;
	public String account;
	public String email;
	public String telefon;

	public Kunde(String idKunde, String name, String geburtstag, String strasse,
			String hausnummer, String plz, String ort, String land,
			String erreichbar, String idAccount, String account, String email,
			String telefon) {
		this.idKunde = idKunde;
		this.geburtstag = geburtstag;
		this.name = name;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		this.erreichbar = erreichbar;
		this.idAccount = idAccount;
		this.account = account;
		this.email = email;
		this.telefon = telefon;
	}

	// Rufe Kundentabelle von Datenbank ab und bilde Customer-Array customers
	public static ArrayList<Kunde> all() {

		Connection con = getConnection();
		ArrayList<Kunde> customers = new ArrayList<Kunde>();

		Statement sta;
		try {
			sta = con.createStatement();
			String sql = "select * FROM `allkunden`";
			
			ResultSet result = sta.executeQuery(sql);
	
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Customer
			// mit Methode...
			while (result.next()) {
				customers.add(getCustomersWithResultSet(result));
			}
			sta.close();
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
			String idKunde = result.getString(1); // getString(1)
			String name = result.getString(2);
			String geburtstag  = result.getString(3);
			String strasse = result.getString(4);
			String hausnummer = result.getString(5);
			String plz = result.getString(6);
			String ort = result.getString(7);
			String land = result.getString(8);
			
			String erreichbar = result.getString(9);
			String idAccount = result.getString(10);
			String account = result.getString(11);
			String email = result.getString(12);
			String telefon = result.getString(13);
			
			
			newCustomer = new Kunde ( idKunde,  name,  geburtstag,  strasse,
					 hausnummer,  plz,  ort,  land,
					 erreichbar,  idAccount,  account,  email,
					 telefon);

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
				this.name,
				this.ort,
				this.land,
				this.erreichbar,
				this.email,
				this.telefon,
				this.account	
		};
		return customerAttributeArray;
	}
	
	
	public static String[] getColumnNames(){
		String[] columnNames ={
			"ID",
			"Name",
			"Ort",
			"Land",
			"Erreichbarkeit",
			"E-Mail",
			"Telefon",
			"Username"
		};
		
		
		return columnNames;
	}
	

	// Speichern der Tabelle

	public void save() {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "";
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
			String query = "";
			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return this.name;
	}
}

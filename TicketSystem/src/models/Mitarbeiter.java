package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Mitarbeiter extends Database_Model {
	
	public String idMitarbeiter;
	public String name;
	public String geburt;
	
	public String strasse;
	public String hausnummer;
	public String plz;
	public String ort;
	public String land;

	public String abteilung;
	public String idAbteilung;
	public String level;
	public String idLevel;
	
	public String email;
	public String telefon;
	public String account;
	public String idAccount;
	
	

	public Mitarbeiter(String idMitarbeiter, String name, String geburt,
			String strasse, String hausnummer, String plz, String ort,
			String land, String abteilung, String idAbteilung, String level,
			String idLevel, String email, String telefon, String account,
			String idAccount) {
		this.idMitarbeiter = idMitarbeiter;
		this.name = name;
		this.geburt = geburt;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		this.abteilung = abteilung;
		this.idAbteilung = idAbteilung;
		this.level = level;
		this.idLevel = idLevel;
		this.email = email;
		this.telefon = telefon;
		this.account = account;
		this.idAccount = idAccount;
	}

	//Mitarbeiter wird beim Login durch den Account erstellt.
	public Mitarbeiter(String idAcc) {
		Connection con = getConnection();
		Statement query;
		try {
			query = con.createStatement();

			String sql = "select * FROM `allmitarbeiter` WHERE idAccount = '"+ idAcc + "' LIMIT 1";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Mitarbeiter
			// mit Methode...
			while (result.next()) {
				
				try {
					
					this.idMitarbeiter= result.getString(1);
					this.name= result.getString(2);
					this.geburt= result.getString(3);
					
					this.strasse= result.getString(4);
					this.hausnummer= result.getString(5);
					this.plz= result.getString(6);
					this.ort= result.getString(7);
					this.land= result.getString(8);

					this.abteilung= result.getString(10);
					this.idAbteilung= result.getString(9);
					this.level= result.getString(16);
					this.idLevel= result.getString(15);
					
					this.email= result.getString(13);
					this.telefon= result.getString(14);
					this.account= result.getString(12);
					this.idAccount= result.getString(11);
					

				} catch (SQLException e) {
					JOptionPane
							.showInputDialog("Fehler bei Mitarbeiter By Account - ResultSet");
				}				
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei Mitarbeiter By Account)");
		}
	}


	// Rufe Mitarbeitertabelle von Datenbank ab und bilde Mitarbeiter-Array mitarbeiter
	public static ArrayList<Mitarbeiter> all() {

		Connection con = getConnection();
		ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();

		Statement query;
		try {
			query = con.createStatement();
			String sql = "select * FROM `allmitarbeiter` ORDER BY idMitarbeiter";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Mitarbeiter
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
	
	public static ArrayList<Mitarbeiter> search(String spalte, String suche){
		Connection con = getConnection();
		ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();

		Statement query;
		try {
			query = con.createStatement();

			String sql = "call search( 'mitarbeiter', '" + spalte + "', '"+ suche +"')";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Mitarbeiter
			// mit Methode...
			while (result.next()) {
				mitarbeiter.add(getMitarbeiterWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei Mitarbeiter-Suche)");
		}
		return mitarbeiter;
			
	}


	// Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Mitarbeiter
	private static Mitarbeiter getMitarbeiterWithResultSet(ResultSet result) {

		Mitarbeiter newMitarbeiter = null;

		try {
			
			String idMitarbeiter= result.getString(1);
			String name= result.getString(2);
			String geburt= result.getString(3);
			
			String strasse= result.getString(4);
			String hausnummer= result.getString(5);
			String plz= result.getString(6);
			String ort= result.getString(7);
			String land= result.getString(8);

			String abteilung= result.getString(10);
			String idAbteilung= result.getString(9);
			String level= result.getString(16);
			String idLevel= result.getString(15);
			
			String email= result.getString(13);
			String telefon= result.getString(14);
			String account= result.getString(12);
			String idAccount= result.getString(11);
			
			newMitarbeiter = new Mitarbeiter( idMitarbeiter,  name,  geburt,
					 strasse,  hausnummer,  plz,  ort,
					 land,  abteilung,  idAbteilung,  level,
					 idLevel,  email,  telefon,  account,
					 idAccount);

		} catch (SQLException e) {
			JOptionPane
					.showInputDialog("Fehler in Mitarbeiter_getMitarbeiterWithResultSet");
		}

		return newMitarbeiter;

	}

	//
	public Object[] toJTableArray() {
		Object[] mitarbeiterAttributeArray = { 	
				this.idMitarbeiter,
				this.name,
				this.plz,
				this.ort,
				this.land,
				this.abteilung,
				this.level,
				this.email,
				this.telefon
		};
		return mitarbeiterAttributeArray;
	}
	
	public static String[] getColumnNames(){
		String[] columnNames = { 
				"ID", 
				"Name",  
				"PLZ", 
				"Ort",
				"Land",
				"Abteilung", 
				"Level",
				"E-Mail",
				"Telefon"
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
		return this.name;
	}
}

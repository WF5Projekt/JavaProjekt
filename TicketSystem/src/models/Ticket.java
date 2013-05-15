package models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ticket extends Database_Model {

	//Ticketdaten Kunde
	public String idKunde;
	public String vorname_k;
	public String nachname_k;
	public String email_k;
	public String telefon_k;
	
	//Ticketdaten Mitarbeiter
	public String idMitarbeiter;
	public String vorname_m;
	public String nachname_m;
	public String abteilung;
	public String email_m;
	public String telefon_m;
	
	//Daten Ticket
	public String idTicket;
	public String level;
	public String kategorie;
	public String prioritaet;
	public String status;
	public String beschreibung;
	public String tmploesung;
	public String erstellzeitpunkt;



	public Ticket(String idKunde, String vorname_k, String nachname_k,
			String email_k, String telefon_k, String idMitarbeiter,
			String vorname_m, String nachname_m, String abteilung,
			String email_m, String telefon_m, String idTicket, String level,
			String kategorie, String prioritaet, String status,
			String beschreibung, String tmploesung, String erstellzeitpunkt) {
		
		this.idKunde = idKunde;
		this.vorname_k = vorname_k;
		this.nachname_k = nachname_k;
		this.email_k = email_k;
		this.telefon_k = telefon_k;
		this.idMitarbeiter = idMitarbeiter;
		this.vorname_m = vorname_m;
		this.nachname_m = nachname_m;
		this.abteilung = abteilung;
		this.email_m = email_m;
		this.telefon_m = telefon_m;
		this.idTicket = idTicket;
		this.level = level;
		this.kategorie = kategorie;
		this.prioritaet = prioritaet;
		this.status = status;
		this.beschreibung = beschreibung;
		this.tmploesung = tmploesung;
		this.erstellzeitpunkt = erstellzeitpunkt;
	}
	// Konstruktur zum Erstellen eines Tickets für die neu-Anlage eines Tickets
	public Ticket(String beschr, String prio, String kat, String idK, String idM) {
		this.beschreibung = beschr;
		this.prioritaet = prio;
		this.idKunde = idK;
		this.kategorie = kat;
		this.idMitarbeiter = idM;
	}

	// Rufe Kundentabelle von Datenbank ab und bilde Customer-Array tickets
	public static ArrayList<Ticket> all() {

		Connection con = getConnection();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Statement query;
		try {
			query = con.createStatement();
			String sql = "select * FROM `allTickets`";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Cusomter
			// mit Methode...
			while (result.next()) {
				tickets.add(getTicketsWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei Ticket-Abfrage)");
		}
		return tickets;
	}
	public static ArrayList<Ticket> search(String spalte, String suche){
		Connection con = getConnection();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Statement query;
		try {
			query = con.createStatement();

			String sql = "call search( 'tickets', '" + spalte + "', '"+ suche +"')";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Cusomter
			// mit Methode...
			while (result.next()) {
				tickets.add(getTicketsWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei Ticket-Suche)");
		}
		return tickets;
			
	}
	
	 public static ArrayList<Ticket> allWithFilter(String wo, String was) {
	        Connection con = getConnection();
	        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	        Statement query;
	        try {
	            query = con.createStatement();
	            String sql = "CALL searchTicket('"+wo+"', '"+was+"')";

	            ResultSet result = query.executeQuery(sql);
	            while (result.next()) {
	                tickets.add(getTicketsWithResultSet(result));
	            }
	            query.close();
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return tickets;
	    }
	
	
			
	
	// Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Ticket
	private static Ticket getTicketsWithResultSet(ResultSet result) {

		Ticket newTicket = null;

		try {
			
			//Ticketdaten Kunde
			String idKunde = result.getString("idKunde");
			String vorname_k = result.getString("vorname_k");
			String nachname_k = result.getString("nachname_k");
			String email_k = result.getString("email_k");
			String telefon_k = result.getString("telefon_k");
			
			//Ticketdaten Mitarbeiter
			String idMitarbeiter = result.getString("idMitarbeiter");
			String vorname_m = result.getString("vorname_m");
			String nachname_m = result.getString("nachname_m");
			String abteilung = result.getString("abteilung");
			String email_m = result.getString("email_m");
			String telefon_m = result.getString("telefon_m");
			
			//Daten Ticket
			String idTicket = result.getString("idTicket");
			String level = result.getString("level");
			String kategorie = result.getString("kategorie");
			String prioritaet = result.getString("prioritaet");
			String status = result.getString("status");
			String beschreibung = result.getString("beschreibung");
			String tmploesung = result.getString("tmploesung");
			String erstellzeitpunkt = result.getString("erstellzeitpunkt");
			
			newTicket = new Ticket( idKunde,  vorname_k,  nachname_k,
					 email_k,  telefon_k,  idMitarbeiter,
					 vorname_m,  nachname_m,  abteilung,
					 email_m,  telefon_m,  idTicket,  level,
					 kategorie,  prioritaet,  status,
					 beschreibung,  tmploesung,  erstellzeitpunkt);

		} catch (SQLException e) {
			JOptionPane
					.showInputDialog("Fehler in Ticket_GetTicketWithResultSet");
		}

		return newTicket;

	}

	// Zur Darstellung in Tabelle , nicht alle Daten -> restliche Daten werden in Detail_Fenster angezeigt.
	public Object[] toJTableArray() {
		Object[] ticketAttributeArray = { 
				//Ticketdaten
				this.status,
				this.level,
				this.kategorie,
				this.prioritaet,
				this.beschreibung,
		};
		return ticketAttributeArray;
	}

	// Speichern der Tabelle

	public void save() {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "UPDATE ticket SET " + "idTicket = '"
					+ this.idTicket + "', " + "beschreibung = '"
					+ this.beschreibung + "', " + "tmploesung = '"
					+ this.tmploesung + "WHERE idTicket = '" + this.idTicket
					+ "';";

			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public Boolean newTicket() {
		boolean erg = false;
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "call newTicket( '"+ this.beschreibung +"', '"+ this.idKunde +"', '"+ this.kategorie + "', '"+ this.prioritaet +"', '" + this.idMitarbeiter + "')";

			stmt.execute(query);
			stmt.close();
			con.close();
			erg = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return erg;
	}

	// Lösche Kunde
	public void delete() {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "DELETE FROM ticket WHERE idTicket = '"+ this.idTicket + "';";
			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
